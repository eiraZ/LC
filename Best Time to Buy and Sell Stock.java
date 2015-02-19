/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one 
share of the stock), design an algorithm to find the maximum profit.

Solution: traverse from back to front
*/
public int maxProfit(int[] prices) {
    if(prices.length == 0) return 0;
    int profit = 0;
    int maxPrice = prices[prices.length - 1];
    
    for (int i = prices.length - 2; i>=0; i--){
        int tempProfit = maxPrice - prices[i];
        profit = Math.max(tempProfit, profit);
        maxPrice = Math.max(prices[i], maxPrice);
    }
    return profit;
}
