class Solution {
    public int change(int amount, int[] coins) {
        
        int len = coins.length;
        
        int dp[][] = new int[len][amount+1];
        
        for(int i=0;i<len;i++)
            dp[i][0] = 0;
        
        for(int j=0;j<=amount;j++) {
            if(j%coins[0]==0)
                dp[0][j] = 1;
            else
                dp[0][j] = 0;
        }
        
        
        for(int index=1;index<len;index++) {
            for(int target=0;target<=amount;target++){
                int notTake = dp[index-1][target];
                int take = 0;
                
                if(target>=coins[index])
                    take = dp[index][target-coins[index]];
                
                dp[index][target] = take + notTake;
                
            }
        }
        
        return dp[len-1][amount];
        
    }
    
//     public int solve(int index, int target, int coins[], int dp[][]) {
        
//         if(index ==0) {
//             if(target % coins[index] ==0)
//                 return 1;
//             else
//                 return 0;
//         }
        
//         if(dp[index][target] != -1)
//             return dp[index][target];
        
//         int notTake = solve(index-1, target, coins, dp);
//         int take = 0;
        
//         if(target>=coins[index])
//             take = solve(index, target-coins[index], coins, dp);
        
//         return dp[index][target] = take+notTake;
//     }
}