class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int len = nums.length;
        int dp[][] = new int[len+1][len+1];
        
        for(int ind=len-1;ind>=0;ind--) {
            for(int prev_ind = ind-1;prev_ind>=-1;prev_ind--){
                
                int notTake = 0 + dp[ind+1][prev_ind+1];
                int take = 0;
                if(prev_ind == -1 || nums[ind]>nums[prev_ind])
                    take = 1 + dp[ind+1][ind+1];
                
                dp[ind][prev_ind+1] = Math.max(take, notTake);
            }
        }
        
        return dp[0][-1+1];
        
//         for(int ar[] : dp)
//             Arrays.fill(ar, -1);
        
        
//         return solve(nums, 0, len, -1, dp);
        
    }
    
    public int solve(int nums[], int ind, int len, int prev_ind, int dp[][]) {
        
        //base case
        if(ind == len)
            return 0;
        
        if(dp[ind][prev_ind+1] != -1)
            return dp[ind][prev_ind+1];
        
        
        int notTake = 0 + solve(nums, ind+1, len, prev_ind, dp);
        
        int take = 0;
        
        if(prev_ind == -1 || nums[ind] > nums[prev_ind])
            take = 1 + solve(nums, ind+1, len, ind, dp);
        
        return dp[ind][prev_ind+1] = Math.max(take, notTake);
    }
}