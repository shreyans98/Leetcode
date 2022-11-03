class Solution {
    public int minCost(int n, int[] cuts) {
        int temp[] = new int[cuts.length+2];
        temp[0] = 0;
        
        for(int i=1;i<temp.length-1;i++)
            temp[i] = cuts[i-1];
        
        temp[temp.length-1] = n;
        Arrays.sort(temp);
        
        int dp[][] = new int[temp.length+1][temp.length+1];
        
        for(int i=cuts.length;i>=1;i--) {
            for(int j=1;j<=cuts.length;j++) {
                if(i>j)
                    continue;
                
                int mini = Integer.MAX_VALUE;
                
                for(int ind = i;ind<=j;ind++) {
                    int cost = temp[j+1] - temp[i-1] + dp[i][ind-1] + dp[ind+1][j];
                    mini = Math.min(mini, cost);
                }
               dp[i][j] = mini;

            }
        }
        
        return dp[1][cuts.length];
        
//         for(int ar[] : dp)
//             Arrays.fill(ar, -1);
        
        
//         return solve(1, cuts.length, temp, dp);
        
    }
    
    public int solve(int i, int j, int temp[], int dp[][]) {
        if(i>j)
            return 0;
        
        int mini = Integer.MAX_VALUE;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        
        for(int ind =i;ind<=j;ind++) {
            int cost = temp[j+1] - temp[i-1] + solve(i, ind-1, temp, dp) + solve(ind+1, j, temp, dp);
            mini = Math.min(mini, cost);
            
        }
        
        return dp[i][j] = mini;
    }
}