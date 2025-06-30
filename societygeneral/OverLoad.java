package societygeneral;

/**
 * Question: Overloading Main Function
 * Overloading Main Method by passing a Single String
 * Overloading Main Method by passing two Strings
 */

public class OverLoad {
	
	public static void main(String[] args) {
		System.out.println("Hi");
		main("Hello World");
		main("Pavan", "reddy");
	}
	
	public static void main (String arg) {
		System.out.println(arg);
	}
	
	public static void main (String arg1,String arg2) {
		System.out.println(arg1 + arg2);
	}

}
