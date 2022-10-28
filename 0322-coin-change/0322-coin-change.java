class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int dp[][] = new int[coins.length][amount+1];
        
        for(int ar[] : dp)
            Arrays.fill(ar, -1);
        
        int solution = solve(coins.length-1, amount, coins, dp);

        
        
        return solution == (int) Math.pow(10, 9) ? -1 : solution;
        
    }
    
    
    public int solve(int index, int amount, int coins[], int dp[][]) {
        
        if(index ==0) {
            if(amount % coins[index] ==0)
                return amount/coins[index];
            else
                return (int) Math.pow(10, 9);
        }
        
        if(amount ==0)
            return 0;
        
        if(dp[index][amount] != -1)
            return dp[index][amount];
        
        
        
        
        
        int notTake = 0 + solve(index-1, amount, coins, dp);
        
        int take = (int) Math.pow(10, 9);
        if(amount >= coins[index])
            take = solve(index, amount-coins[index], coins, dp) + 1;
        
        return dp[index][amount] = Math.min(take, notTake);
        
        
    }
}