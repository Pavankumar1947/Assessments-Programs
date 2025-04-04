package ibm;

import java.util.Scanner;

public class StockBuyandSell {
	static int maxProfitRec(int[] price, int start, int end) {
        int res = 0;

        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (price[j] > price[i]) {
                    int curr = (price[j] - price[i]) + 
                                maxProfitRec(price, start, i - 1) + 
                                maxProfitRec(price, j + 1, end);
                    res = Math.max(res, curr);
                }
            }
        }
        return res;
    }

    static int maximumProfit(int[] prices) {
        return maxProfitRec(prices, 0, prices.length - 1);
    }

    public static void main(String[] args) {
        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(maximumProfit(prices));
    }

}
