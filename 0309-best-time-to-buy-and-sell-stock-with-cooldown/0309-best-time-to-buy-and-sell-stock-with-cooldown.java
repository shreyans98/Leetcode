class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        
        int dp[][] = new int[len+1][2];
        for(int ar[]: dp)
            Arrays.fill(ar, -1);
        
        return solve(0, len, 0, prices, dp);
    }
    
    
    public int solve(int ind, int len, int buy, int prices[], int dp[][]) {
        if(ind>=len)
            return 0;
        
        if(dp[ind][buy] != -1)
            return dp[ind][buy];
        
        int profit = 0;
        
        
        if(buy ==0)//we can buy
            profit = Math.max(0 + solve(ind+1, len, 0, prices, dp), -prices[ind]+solve(ind+1, len, 1, prices, dp));
        
        else
            profit = Math.max(0 + solve(ind+1, len, 1, prices, dp), prices[ind]+solve(ind+2, len, 0, prices, dp));
        
        return dp[ind][buy] = profit;
            
    }
}