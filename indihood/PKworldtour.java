package indihood;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PKworldtour {  //	PK world tour
public static void main(String[] args)throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
    int N = Integer.parseInt(br.readLine().trim());
    int[][] cost = new int[N][3];
    for (int i = 0; i < N; i++) {
        String[] input = br.readLine().trim().split(" ");
        cost[i][0] = Integer.parseInt(input[0]); // Plane cost
        cost[i][1] = Integer.parseInt(input[1]); // Ship cost
        cost[i][2] = Integer.parseInt(input[2]); // Helicopter cost
    }
    int[][] dp = new int[N][3];
    dp[0][0] = cost[0][0];
    dp[0][1] = cost[0][1];
    dp[0][2] = cost[0][2];
    for (int i = 1; i < N; i++) {
        dp[i][0] = cost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]); // Choosing Plane
        dp[i][1] = cost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]); // Choosing Ship
        dp[i][2] = cost[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]); // Choosing Helicopter
    }
    int minCost = Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2]));
    System.out.println(minCost);
}
}
