import java.io.*;
import java.util.*;

public class BestTimeToBuyAndSellStock  {
    public int maxProfit(int[] prices) {
        int minCP = prices[0], maxProfit = 0, n = prices.length;
        for(int i = 1; i < n; i++){
            maxProfit = Math.max(maxProfit, prices[i] - minCP);
            minCP = Math.min(minCP, prices[i]);
        }
        return maxProfit;
    }
}
