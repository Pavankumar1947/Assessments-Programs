package indihood;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NumberOfTriangles {  // number of triangles
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int result = numberOfTriangles(N);
        System.out.println(result);
    }

    private static int numberOfTriangles(int N) {
        if (N < 3) {
            return 0; 
        }
        return (N * (N - 1) * (N - 2)) / 6; 
    }

}
