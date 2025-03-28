package indihood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Directions {   // sad Alice
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim()); // Number of test cases

        while (T-- > 0) {
            String S = br.readLine().trim();
            Map<Character, Integer> countMap = new HashMap<>();

            // Initialize the map to avoid NullPointerException
            countMap.put('N', 0);
            countMap.put('S', 0);
            countMap.put('E', 0);
            countMap.put('W', 0);

            // Count occurrences of each direction
            for (char c : S.toCharArray()) {
                countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            }

            // Cancel out opposite directions
            int minNS = Math.min(countMap.get('N'), countMap.get('S'));
            int minEW = Math.min(countMap.get('E'), countMap.get('W'));

            // If the minimal path results in no movement
            if (minNS == 0 && minEW == 0) {
                System.out.println("Sad Alice");
            } else {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < minNS; i++) result.append('N');
                for (int i = 0; i < minEW; i++) result.append('E');
                for (int i = 0; i < minNS; i++) result.append('S');
                for (int i = 0; i < minEW; i++) result.append('W');
                System.out.println(result.toString());
            }
        }
    }

}
