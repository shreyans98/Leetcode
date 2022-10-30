class Solution {
    public int maxProfit(int[] prices, int fee) {
        
        int len = prices.length;
        int ahead[] = new int[2];
        int curr[] = new int[2];
        
        for(int ind=len-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++) {
                
                if(buy ==0)
                    curr[buy] = Math.max(0 + ahead[0], -prices[ind]+ahead[1]);
                
                if(buy ==1)
                    curr[buy] = Math.max(0 + ahead[1], prices[ind]-fee+ahead[0]);
                
            }
            ahead = (int[])(curr.clone());
        }
        
        return curr[0];
        
//         for(int ar[] : dp)
//             Arrays.fill(ar, -1);
        
//         return solve(0, len, fee, 0, prices, dp);
        
    }
    
    /*
    
     int len = prices.length;
        int dp[][] = new int[len+1][2];
        
        for(int ind=len-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++) {
                
                if(buy ==0)
                    dp[ind][buy] = Math.max(0 + dp[ind+1][0], -prices[ind]+dp[ind+1][1]);
                
                if(buy ==1)
                    dp[ind][buy] = Math.max(0 + dp[ind+1][1], prices[ind]-fee+dp[ind+1][0]);
                
            }
        }
        
        return dp[0][0];
    
    
    */
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