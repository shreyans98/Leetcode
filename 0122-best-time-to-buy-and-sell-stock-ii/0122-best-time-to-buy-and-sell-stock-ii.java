class Solution {
    public int maxProfit(int[] prices) {
        
        int len = prices.length;
        //int buy = 0;
        
        int dp[][] = new int[len+1][2];
        dp[len][0] = dp[len][1] = 0;
        
        for(int ind=len-1;ind>=0;ind--) {
            for(int buy = 0;buy<=1;buy++ ) {
                int profit = 0;
                
                if(buy == 0)  
                    profit = Math.max(-prices[ind] + dp[ind+1][1],  0 + dp[ind+1][0]);
                
                if(buy == 1)
                    profit = Math.max( prices[ind] + dp[ind+1][0], 0 + dp[ind+1][1]);  
              
                dp[ind][buy] = profit;

            }
        }
        
        return dp[0][0];
        
        
//         for(int ar[] : dp)
//             Arrays.fill(ar, -1);
        
        
//         return solve(0, len, prices, buy, dp);
    }
    
    public int solve(int ind, int len, int prices[], int buy, int dp[][]) {
        if(ind == len)
            return 0;
        
        
        if(dp[ind][buy] != -1)
            return dp[ind][buy];
        
        int profit = 0;
        
        
        
        if(buy == 0)  
            profit = Math.max(-prices[ind] + solve(ind+1, len, prices, 1, dp), 0 + solve(ind+1, len, prices, 0, dp));
        
        
        else {
            profit = Math.max( prices[ind] + solve(ind+1, len, prices, 0, dp), 0 + solve(ind+1, len, prices, 1, dp));
        }
        
        return dp[ind][buy] = profit;
    }
}