package idfcBank;

import java.util.*;

//Round 1   Hackerrank Question1.

public class MagicalBinaryString {

	// Main method to run the program
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a binary string: ");
		String input = scanner.nextLine();
		String result = largestMagical(input);
		System.out.println("Largest Magical String: " + result);
		scanner.close();
	}

	// Public method that calls the recursive function
	public static String largestMagical(String binString) {
		return makeLargest(binString);
	}

	/**
     * Recursively computes the largest magical binary string by:
     * - Breaking the input into valid magical substrings
     * - Recursively optimizing inner parts
     * - Sorting them in descending lexicographical order
     * - Concatenating the results
     */
	private static String makeLargest(String s) {
		List<String> substrings = new ArrayList<>();
		int count = 0;
		int start = 0;

		// Split input string into valid magical substrings
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1')
				count++;
			else
				count--;

			if (count == 0) {
				// Found a valid magical substring from 'start' to 'i'
				String inner = s.substring(start + 1, i);
				String optimizedInner = makeLargest(inner); // Recurse into inner part
				substrings.add("1" + optimizedInner + "0");
				start = i + 1;
			}
		}

		//Sort substrings in descending lexicographic order
		substrings.sort(Collections.reverseOrder());

		// Concatenate all sorted substrings
		StringBuilder result = new StringBuilder();
		for (String sub : substrings) {
			result.append(sub);
		}

		return result.toString();
	}
}