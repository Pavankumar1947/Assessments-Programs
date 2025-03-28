package indihood;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvenAdd {  //even add
	public static void main(String[] args)throws Exception  {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String input = br.readLine(); 
	        String[] inputArray = input.replaceAll("[\\[\\]]", "").split(",");
	        List<Integer> evenNumbers = new ArrayList<>();
	        List<Integer> oddNumbers = new ArrayList<>();
	        for (String num : inputArray) {
	            int number = Integer.parseInt(num.trim()); 
	            if (number % 2 == 0) {
	                evenNumbers.add(number);
	            } else {
	                oddNumbers.add(number);
	            }
	        }
	        System.out.print(evenNumbers);
	        System.out.print(oddNumbers);
	    }
}
