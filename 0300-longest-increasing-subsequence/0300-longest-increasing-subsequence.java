class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int len = nums.length;
        int dp[] = new int[len];
        int hash[] = new int[len];
        int maxi = 1;
        
        Arrays.fill(dp, 1);
        
        for(int ind=0;ind<len;ind++) {
            for(int prev_ind=0; prev_ind<ind;prev_ind++) {
                
                if(nums[prev_ind]<nums[ind])
                    dp[ind] = Math.max(1 + dp[prev_ind], dp[ind]);
            }
            
            maxi = Math.max(maxi, dp[ind]);
        }
        
        return maxi;
        
        
        
       
        
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
    
    /*
    
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
        
        
        Memory optimization
         int len = nums.length;
        int next[] = new int[len+1];
        int curr[] = new int[len+1];
        
        for(int ind=len-1;ind>=0;ind--) {
            for(int prev_ind = ind-1;prev_ind>=-1;prev_ind--){
                
                int notTake = 0 + next[prev_ind+1];
                int take = 0;
                if(prev_ind == -1 || nums[ind]>nums[prev_ind])
                    take = 1 + next[ind+1];
                
                curr[prev_ind+1] = Math.max(take, notTake);
            }
            next = curr;
        }
        
        return next[-1+1];
    
    
    
    */
}