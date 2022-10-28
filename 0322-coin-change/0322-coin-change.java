class Solution {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        
        int dp[][] = new int[len][amount+1];
        
        
        for(int i=0;i<len;i++)
            dp[i][0] = 0;
        
        
        
        for(int j=0;j<= amount;j++) {
            
            if(j % coins[0] ==0)
                dp[0][j] = j/coins[0];
            else
                dp[0][j] = (int) Math.pow(10, 9);
        }
        
        
        for(int i=1;i<len;i++) {
            for(int target = 0;target<=amount;target++) {
                
                int notTake = 0 + dp[i-1][target];
                int take = (int) Math.pow(10, 9);
                
                if(target>=coins[i])
                    take = 1 + dp[i][target-coins[i]];
                
                dp[i][target] = Math.min(take, notTake);
            }
        }
        
        return dp[len-1][amount] == (int) (Math.pow(10, 9)) ? -1 : dp[len-1][amount];
    }
    
    

}