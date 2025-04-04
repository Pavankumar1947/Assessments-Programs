package cognitiveclouds;

public class PalindromeChecker {
	public static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equalsIgnoreCase(reversed); // Case-insensitive comparison
    }

    public static void main(String[] args) {
        String testStr = "Madam";
        System.out.println(testStr + " is palindrome? " + isPalindrome(testStr));
    }

}
