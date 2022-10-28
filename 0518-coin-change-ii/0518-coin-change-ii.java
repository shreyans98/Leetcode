class Solution {
    public int change(int amount, int[] coins) {
        
        int len = coins.length;
        
        int dp[][] = new int[len][amount+1];
        
        for(int ar[] : dp)
            Arrays.fill(ar, -1);
        
        return solve(len-1, amount, coins, dp);
        
    }
    
    public int solve(int index, int target, int coins[], int dp[][]) {
        
        if(index ==0) {
            if(target % coins[index] ==0)
                return 1;
            else
                return 0;
        }
        
        if(dp[index][target] != -1)
            return dp[index][target];
        
        int notTake = solve(index-1, target, coins, dp);
        int take = 0;
        
        if(target>=coins[index])
            take = solve(index, target-coins[index], coins, dp);
        
        return dp[index][target] = take+notTake;
    }
}