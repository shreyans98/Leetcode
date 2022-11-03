class Solution {
    public int maxCoins(int[] nums) {
        
        int temp[] = new int[nums.length+2];
        temp[0] = 1;
        
        for(int i=1;i<temp.length-1;i++)
            temp[i] = nums[i-1];
        temp[temp.length-1] = 1;
        
        int dp[][] = new int[temp.length+2][temp.length+2];
        
        
        for(int i = nums.length;i>=1;i--) {
            for(int j=1;j<=nums.length;j++) {
                if(i>j)
                    continue;
                
                int mini = Integer.MIN_VALUE;
                for(int ind = i;ind<=j;ind++) {
                    int cost = temp[i-1]*temp[ind]*temp[j+1] + dp[i][ind-1] + dp[ind+1][j];
                    mini = Math.max(mini, cost);
                }
                dp[i][j] = mini;
            }
        }
        
        
        return dp[1][nums.length];
        
//         for(int ar[] : dp)
//             Arrays.fill(ar, -1);
        
        
//         return solve(1, nums.length, temp, dp);
        
    }
    
    public int solve(int i, int j, int temp[], int dp[][]) {
        //base case
        if(i>j)
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int mini = Integer.MIN_VALUE;
        for(int ind = i;ind<=j;ind++){
            int cost = temp[i-1]*temp[ind]*temp[j+1] + solve(i, ind-1, temp, dp) + solve(ind+1, j, temp, dp);
            mini = Math.max(mini, cost);
        }
        
        return dp[i][j] = mini;
    }
}