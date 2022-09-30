class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        
        for(int i=0; i<prices.length;i++) {
            min = Math.min(min, prices[i]); //to get the minimum buying price from the array
            
            //condition to check if we have a selling price > buying price on days after the stock is bought else profit will be 0. If possible, return the maximum value
            if(prices[i]-min > profit) 
                profit = prices[i]-min;
            
        }
        return profit;
        
    }
}
