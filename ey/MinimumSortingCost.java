package ey;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinimumSortingCost {
	public static int minimumCost(List<Integer> str) {
        // default output (can be changed)
        int result = -404;
        if (str == null || str.size() == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int val : str) {
            if (val < min) min = val;
            if (val > max) max = val;
        }

        result = max - min;
        return result;
    }

    public static void main(String[] args) {
    	System.out.print("Enter a String :");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<Integer> str = new ArrayList<>();

        for (char ch : s.toCharArray()) {
            str.add(ch - 'a');
        }

        System.out.println(minimumCost(str));

        sc.close();
    }

}
