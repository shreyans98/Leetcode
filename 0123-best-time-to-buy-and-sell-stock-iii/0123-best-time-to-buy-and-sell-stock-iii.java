class Solution {
    public int maxProfit(int[] prices) {
        
        int len  = prices.length;
        int buy = 0;
        
        int dp[][][] = new int[len+1][2][3];
        
        for(int ar[][] : dp)
            for(int arr[] : ar)
                Arrays.fill(arr, -1);
        
        return solve(0, len, prices, buy, 2, dp);
        
    }
    
    public int solve(int ind, int len, int prices[], int buy, int cap, int dp[][][]) {
        //base case
        
        if(ind == len || cap ==0)
            return 0;
        
        if(dp[ind][buy][cap] != -1)
            return dp[ind][buy][cap];
        
        int profit = 0;
        
        if(buy ==0) 
            profit = Math.max(-prices[ind] + solve(ind+1, len, prices, 1, cap, dp), 0 + solve(ind+1, len, prices, 0, cap, dp));
        
        else
            profit = Math.max(prices[ind] + solve(ind+1, len, prices, 0, cap-1, dp), 0 + solve(ind+1, len, prices, 1, cap, dp));
        
        return dp[ind][buy][cap] = profit;
    }
}