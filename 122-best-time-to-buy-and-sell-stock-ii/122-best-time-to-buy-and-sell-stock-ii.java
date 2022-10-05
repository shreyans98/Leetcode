class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        
//Intution is everytime there is an increase order seen in the array, we are going to add the difference between the two to our total profit.        
        for(int i=1;i<prices.length;i++) {
            if(prices[i]>prices[i-1])
                profit += prices[i] - prices[i-1];
            
            
        }
        return profit;
        
    }
}