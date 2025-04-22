package lti_MindTree;

public class CountA {
	public static void main(String[] args) {
		String str = "Amazon Alexa App";
		int count = 0;
		for (char c : str.toCharArray()) {
			if (c == 'A' || c == 'a')count++;
		}
		System.out.println("Number of A's: " + count);
	}

}
