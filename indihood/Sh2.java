package indihood;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Result {
    public static List<Long> getNetProfit(List<String> events) {
        Map<String, Integer> productQuantity = new HashMap<>();
        Map<String, Integer> productPrice = new HashMap<>();
        Map<String, Integer> initialPrice = new HashMap<>();
        List<Long> results = new ArrayList<>();
        long totalProfit = 0;
        for (String event : events) {
            String[] parts = event.split(" ");
            if (parts[0].equals("BUY")) {
                String product = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                productQuantity.put(product, productQuantity.getOrDefault(product, 0) + quantity);
                if (!productPrice.containsKey(product)) {
                    productPrice.put(product, 0);
                    initialPrice.put(product, 0);
                }
            } else if (parts[0].equals("SELL")) {
                String product = parts[1];
                int quantity = Integer.parseInt(parts[2]);

                if (productQuantity.containsKey(product)) {
                    productQuantity.put(product, productQuantity.get(product) - quantity);
                }
            } else if (parts[0].equals("CHANGE")) {
                String product = parts[1];
                int priceChange = Integer.parseInt(parts[2]);

                if (productPrice.containsKey(product)) {
                    int newPrice = productPrice.get(product) + priceChange;
                    productPrice.put(product, newPrice);
                }

            } else if (parts[0].equals("QUERY")) {
                totalProfit = 0;
                for (String product : productQuantity.keySet()) {
                    int quantity = productQuantity.get(product);
                    int currentPrice = productPrice.getOrDefault(product, 0);
                    int initPrice = initialPrice.getOrDefault(product, 0);
                    
                    totalProfit += (long) quantity * (currentPrice - initPrice);
                }
                results.add(totalProfit);
            }
        }
        return results;
    }
}

public class Sh2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int eventsCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<String> events = new ArrayList<>();

        for (int i = 0; i < eventsCount; i++) {
            String eventsItem = bufferedReader.readLine();
            events.add(eventsItem);
        }

        List<Long> result = Result.getNetProfit(events);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));
            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
