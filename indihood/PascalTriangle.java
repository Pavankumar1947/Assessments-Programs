package indihood;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	 public static void main(String args[]) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int n = Integer.parseInt(br.readLine().trim()); 
	        List<List<Integer>> pascalTriangle = generatePascal(n);
	        System.out.println(pascalTriangle);
	    }

	    public static List<List<Integer>> generatePascal(int n) {
	        List<List<Integer>> triangle = new ArrayList<>();
	        for (int i = 0; i < n; i++) {
	            List<Integer> row = new ArrayList<>();
	            for (int j = 0; j <= i; j++) {
	                if (j == 0 || j == i) {
	                    row.add(1); 
	                } else {
	                    row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
	                }
	            }
	            triangle.add(row);
	        }
	        return triangle;
	    }

}
