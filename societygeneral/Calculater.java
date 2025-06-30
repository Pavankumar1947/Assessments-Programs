package societygeneral;

import java.util.Scanner;

public class Calculater {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int num1 = Integer.parseInt(sc.nextLine());
			int num2 = Integer.parseInt(sc.nextLine());
			
			String operator = sc.nextLine();
			int result = 0;
			
			switch (operator) {
			case "+":
				result = num1 + num2;
				System.out.println("Rsult " + result);
				break;
			case "-":
				result = num1 - num2;
				System.out.println("Rsult" + result);
				break;
			case "*":
				result = num1 * num2;
				System.out.println("Rsult " + result);
				break;
			case "/":
				result = num1 / num2;
				System.out.println("Rsult " + result);
				break;
			default:
				System.out.println("A error Occured: Invalid Operator: "+ operator);
			}
		}catch(ArithmeticException e) {
			System.out.println("Arithmatic error Occured" + e.getMessage());
		}catch(NumberFormatException e) {
			System.out.println("Invalid number format " + e.getMessage());
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("An error Occured: Invalid Input Occured" );
		}
	}

}
