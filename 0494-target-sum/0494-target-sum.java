class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        
        int totSum = 0;
        
        for(int ar: nums)
            totSum += ar;
        
        if(totSum - target<0)
            return 0;
        
        if((totSum-target)%2 ==1)
            return 0;
        
        int s2 = (totSum-target)/2;
        
        return solve(len, s2, nums);
        
    }
    
    
    public static int solve(int n, int s2, int arr[]) {
         int dp[][] = new int[n][s2+1];
        
        if(arr[0] ==0)
            dp[0][0] = 2;
        else
            dp[0][0] = 1;
        
        if(arr[0] != 0 && arr[0]<=s2)
            dp[0][arr[0]] = 1;
        
        for(int i=1;i<n;i++) {
            for(int t=0;t<=s2;t++) {
                int notTake = dp[i-1][t];
                int take = 0;
                
                if(arr[i] <= t)
                    take = dp[i-1][t-arr[i]];
                
                dp[i][t] = (take+notTake);
            }
        }
                
        return dp[n-1][s2];
    }
    
    
}