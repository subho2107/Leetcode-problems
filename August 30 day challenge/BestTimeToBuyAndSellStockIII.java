public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if(prices.length==0)return 0;
        int firstBuy = Integer.MIN_VALUE, secondBuy = Integer.MIN_VALUE, secondSell = 0, firstSell = 0;
        for(int pos = 0; pos < prices.length; pos++){
            firstBuy = Math.max(firstBuy, 0-prices[pos]);
            firstSell = Math.max(firstSell, firstBuy+prices[pos]);
            secondBuy = Math.max(secondBuy, firstSell-prices[pos]);
            secondSell = Math.max(secondSell, secondBuy+prices[pos]);
        }
        return secondSell;
    }
}
