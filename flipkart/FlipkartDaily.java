package flipkart;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class FlipkartDaily {
	static class Item {
		String brand;
		String category;
		int price;
		int quantity;

		public Item(String brand, String category, int price, int quantity) {
			this.brand = brand;
			this.category = category;
			this.price = price;
			this.quantity = quantity;
		}

		@Override
		public String toString() {
			return brand + ", " + category + ", " + quantity;
		}
	}

	// In-memory storage of items
	static Map<String, Item> inventory = new HashMap<>();

	// Composite key: brand|category
	private static String getKey(String brand, String category) {
		return brand + "|" + category;
	}

	public static void addItem(String brand, String category, int price) {
		String key = getKey(brand, category);
		inventory.putIfAbsent(key, new Item(brand, category, price, 0));
	}

	public static void addInventory(String brand, String category, int quantity) {
		String key = getKey(brand, category);
		if (inventory.containsKey(key)) {
			inventory.get(key).quantity += quantity;
		} else {
			System.out.println("Item doesn't exist: " + brand + " " + category);
		}
	}

	public static List<Item> searchItems(Map<String, List<String>> filters, String orderBy, String order) {
		return inventory.values().stream().filter(item -> {
			boolean matches = true;
			if (filters.containsKey("brand")) {
				matches &= filters.get("brand").contains(item.brand);
			}
			if (filters.containsKey("category")) {
				matches &= filters.get("category").contains(item.category);
			}
			if (filters.containsKey("price")) {
				List<String> priceRange = filters.get("price");
				int from = priceRange.size() > 0 ? Integer.parseInt(priceRange.get(0)) : Integer.MIN_VALUE;
				int to = priceRange.size() > 1 ? Integer.parseInt(priceRange.get(1)) : Integer.MAX_VALUE;
				matches &= (item.price >= from && item.price <= to);
			}
			return matches;
		}).sorted((a, b) -> {
			int cmp = 0;
			if ("price".equalsIgnoreCase(orderBy)) {
				cmp = Integer.compare(a.price, b.price);
			} else if ("itemqty".equalsIgnoreCase(orderBy)) {
				cmp = Integer.compare(a.quantity, b.quantity);
			}
			return "desc".equalsIgnoreCase(order) ? -cmp : cmp;
		}).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		addItem("Amul", "Milk", 100);
		addItem("Amul", "Curd", 50);
		addItem("Nestle", "Milk", 60);
		addItem("Nestle", "Curd", 90);

		addInventory("Amul", "Milk", 10);
		addInventory("Nestle", "Milk", 5);
		addInventory("Nestle", "Curd", 10);
		addInventory("Amul", "Milk", 10);
		addInventory("Amul", "Curd", 5);

		System.out.println("\nSearch by brand = Nestle");
		Map<String, List<String>> filter1 = new HashMap<>();
		filter1.put("brand", Arrays.asList("Nestle"));
		searchItems(filter1, "price", "asc").forEach(System.out::println);

		System.out.println("\nSearch by category = Milk");
		Map<String, List<String>> filter2 = new HashMap<>();
		filter2.put("category", Arrays.asList("Milk"));
		searchItems(filter2, "price", "asc").forEach(System.out::println);

		System.out.println("\nSearch by category = Milk, order by price desc");
		searchItems(filter2, "price", "desc").forEach(System.out::println);

		System.out.println("\nSearch by price range 70 to 100");
		Map<String, List<String>> filter3 = new HashMap<>();
		filter3.put("price", Arrays.asList("70", "100"));
		searchItems(filter3, "price", "asc").forEach(System.out::println);

		System.out.println("\nSearch by category=Milk and price range 70 to 100, order by price desc");
		Map<String, List<String>> filter4 = new HashMap<>();
		filter4.put("category", Arrays.asList("Milk"));
		filter4.put("price", Arrays.asList("70", "100"));
		searchItems(filter4, "price", "desc").forEach(System.out::println);
	}

}
