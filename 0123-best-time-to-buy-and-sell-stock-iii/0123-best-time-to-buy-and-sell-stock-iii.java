class Solution {
    public int maxProfit(int[] prices) {
        
        int len  = prices.length;
        int buy = 0;
        
        int after[][] = new int[2][3];
        int curr[][] = new int[2][3];
        
        //int dp[][][] = new int[len+1][2][3];
        
        //base case for tabulation
        
//         for(buy = 0;buy<=1;buy++) {
//             for(int j = 0;j<=2;j++){
//                 dp[0][buy][j] = 0;
//             }
//         }
        
//         for(int i=0;i<=len;i++){
//             for(int k=0;k<=1;k++){
//                 dp[i][k][0] = 0;
//             }
//         }
        
        
        for(int i=len-1;i>=0;i--){
            for(int buys=0;buys<=1;buys++){
                for(int cap=1;cap<=2;cap++) {
                    
                    if(buys == 0)
                        curr[buys][cap] = Math.max(-prices[i] + after[1][cap], 0 + after[0][cap]);
                       // dp[i][buys][cap] = Math.max(-prices[i] + after[1][cap], 0 + after[0][cap]);
                    
                    if(buys ==1)
                        curr[buys][cap] = Math.max(prices[i] + after[0][cap-1], 0 + after[1][cap]);
                       // dp[i][buys][cap] = Math.max(prices[i] + dp[i+1][0][cap-1], 0 + dp[i+1][1][cap]);
                }
            }
            after = curr;
        }
        return after[0][2];
        
        
        
        
        
        
//         for(int ar[][] : dp)
//             for(int arr[] : ar)
//                 Arrays.fill(arr, -1);
        
//         return solve(0, len, prices, buy, 2, dp);
        
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