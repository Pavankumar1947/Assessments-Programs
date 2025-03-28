package indihood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SlideParrern {  //Slide Pattern
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int n = Integer.parseInt(br.readLine().trim());  
	        
	        for (int i = 1; i <= n; i++) {
	            for (int j = 1; j <= n - i; j++) {
	                System.out.print(" ");
	            }
	            
	            if (i == 1 || i == n) {
	                for (int j = 1; j <= n; j++) {
	                    System.out.print("*");
	                }
	            } else {
	                System.out.print("*");
	                for (int j = 1; j <= n - 2; j++) {
	                    System.out.print(" ");
	                }
	                System.out.print("*");
	            }
	            System.out.println();
	        }
	    }

}

/*
OUTPUT

2
 **
**

3
  ***
 * *
***

4
   ****
  *  *
 *  *
****

5
    *****
   *   *
  *   *
 *   *
*****

6
     ******
    *    *
   *    *
  *    *
 *    *
******


*/
