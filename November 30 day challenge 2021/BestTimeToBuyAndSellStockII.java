import java.io.*;
import java.util.*;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int profit = 0, n = prices.length;
        for(int i = 0; i < n-1; i++){
            if(prices[i] <= prices[i+1])
                profit += prices[i+1]-prices[i];
        }
        return profit;
    }

    public int maxProfit2(int[] prices) {
        int costPrice = prices[0], profit = 0, n = prices.length;
        for(int i = 0; i < n-1; i++){
            costPrice = Math.min(costPrice, prices[i]);
            if(prices[i] <= prices[i+1])
                continue;
            profit += prices[i]-costPrice;
            costPrice = prices[i+1];
        }
        if(costPrice < prices[n-1])
            profit += prices[n-1]-costPrice;
        return profit;
    }
}
