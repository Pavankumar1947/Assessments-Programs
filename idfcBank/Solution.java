package idfcBank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

//Round 1   Hackerrank Question No2.

//Interface for Drink
interface Drink {
	int getQuantityLeft();

	int getPrice();

	String getName();

	void serveDrink();
}

//Exception when drink is out of stock
class OutOfStockException extends Exception {
	public OutOfStockException(String message) {
		super(message);
	}
}

//Exception when money is not enough
class InsufficientMoneyException extends Exception {
	public InsufficientMoneyException() {
		super();
	}
}

//Summary class to return served drink and change
class ServeDrinkSummary {
	Drink servedDrink;
	int change;

	public ServeDrinkSummary(Drink servedDrink, int change) {
		this.servedDrink = servedDrink;
		this.change = change;
	}
}

class VendingMachine {
	private Map<Integer, Drink> buttonMap = new HashMap<>();

	// Register a drink to a button
	public void registerDrink(int buttonIdx, Drink drink) {
		buttonMap.put(buttonIdx, drink);
	}

	// Serve drink on button press
	public ServeDrinkSummary dispatch(int buttonPressed, int money)
			throws OutOfStockException, InsufficientMoneyException {
		Drink drink = buttonMap.get(buttonPressed);

		if (drink.getQuantityLeft() <= 0) {
			throw new OutOfStockException(drink.getName() + " is out of stock");
		}

		if (money < drink.getPrice()) {
			throw new InsufficientMoneyException();
		}

		// Serve drink and calculate change
		drink.serveDrink();
		int change = money - drink.getPrice();
		return new ServeDrinkSummary(drink, change);
	}
}

//Implementation of Coke drink
class Coke implements Drink {
	private int price;
	private String name;
	private int quantityLeft;

	public Coke(int price, String name, int quantityLeft) {
		this.price = price;
		this.name = name;
		this.quantityLeft = quantityLeft;
	}

	public int getPrice() {
		return this.price;
	}

	public String getName() {
		return this.name;
	}

	public int getQuantityLeft() {
		return this.quantityLeft;
	}

	public void serveDrink() {
		if (this.quantityLeft > 0) {
			this.quantityLeft -= 1;
		}
	}
}

//Implementation of Fanta drink
class Fanta implements Drink {
	private int price;
	private String name;
	private int quantityLeft;

	public Fanta(int price, String name, int quantityLeft) {
		this.price = price;
		this.name = name;
		this.quantityLeft = quantityLeft;
	}

	public int getPrice() {
		return this.price;
	}

	public String getName() {
		return this.name;
	}

	public int getQuantityLeft() {
		return this.quantityLeft;
	}

	public void serveDrink() {
		if (this.quantityLeft > 0) {
			this.quantityLeft -= 1;
		}
	}
}

//Implementation of Sprite drink
class Sprite implements Drink {
	private int price;
	private String name;
	private int quantityLeft;

	public Sprite(int price, String name, int quantityLeft) {
		this.price = price;
		this.name = name;
		this.quantityLeft = quantityLeft;
	}

	public int getPrice() {
		return this.price;
	}

	public String getName() {
		return this.name;
	}

	public int getQuantityLeft() {
		return this.quantityLeft;
	}

	public void serveDrink() {
		if (this.quantityLeft > 0) {
			this.quantityLeft -= 1;
		}
	}
}

//Solution driver class
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int[] quantity = new int[3];
		int[] pricePerUnit = new int[3];
		int[] buttonAssigned = new int[3];

		String[] arr = br.readLine().split(" ");
		for (int i = 0; i < 3; i++)
			quantity[i] = Integer.parseInt(arr[i]);

		arr = br.readLine().split(" ");
		for (int i = 0; i < 3; i++)
			pricePerUnit[i] = Integer.parseInt(arr[i]);

		arr = br.readLine().split(" ");
		for (int i = 0; i < 3; i++)
			buttonAssigned[i] = Integer.parseInt(arr[i]);

		VendingMachine vendingMachine = new VendingMachine();

		Drink coke = new Coke(pricePerUnit[0], "Coke", quantity[0]);
		Drink fanta = new Fanta(pricePerUnit[1], "Fanta", quantity[1]);
		Drink sprite = new Sprite(pricePerUnit[2], "Sprite", quantity[2]);

		vendingMachine.registerDrink(buttonAssigned[0], coke);
		vendingMachine.registerDrink(buttonAssigned[1], fanta);
		vendingMachine.registerDrink(buttonAssigned[2], sprite);

		out.println("Vending machine set up");

		int totalRequests = Integer.parseInt(br.readLine().trim());

		while (totalRequests-- > 0) {
			arr = br.readLine().split(" ");
			int buttonPressed = Integer.parseInt(arr[0]);
			int money = Integer.parseInt(arr[1]);

			try {
				ServeDrinkSummary summary = vendingMachine.dispatch(buttonPressed, money);
				summary.servedDrink.serveDrink(); // already done in dispatch, but safe
				out.println(summary.servedDrink.getName() + " " + summary.change);
			} catch (OutOfStockException e) {
				out.println(e.getMessage());
			} catch (InsufficientMoneyException e) {
				out.println("Insufficient money");
			}
		}

		out.flush();
		out.close();
	}
}
