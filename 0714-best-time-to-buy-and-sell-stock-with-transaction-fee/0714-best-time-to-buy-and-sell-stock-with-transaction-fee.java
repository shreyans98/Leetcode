class Solution {
    public int maxProfit(int[] prices, int fee) {
        
        int len = prices.length;
        int dp[][] = new int[len+1][2];
        
        for(int ar[] : dp)
            Arrays.fill(ar, -1);
        
        return solve(0, len, fee, 0, prices, dp);
        
    }
    
    public int solve(int ind, int len, int fee, int buy, int prices[], int dp[][]) {
        
        if(ind>=len)
            return 0;
        
        if(dp[ind][buy] != -1)
            return dp[ind][buy];
        
        int profit = 0;
        
        if(buy ==0)
            profit = Math.max(0 + solve(ind+1, len, fee, 0, prices, dp), -prices[ind]+solve(ind+1, len, fee, 1, prices, dp));
        
        else
            profit = Math.max(0+solve(ind+1, len, fee, 1, prices, dp), prices[ind]-fee+solve(ind+1, len, fee, 0, prices, dp));
        
        return dp[ind][buy] = profit;
    }
}