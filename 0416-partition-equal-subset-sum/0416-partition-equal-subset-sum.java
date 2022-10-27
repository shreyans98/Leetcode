class Solution {
    public boolean canPartition(int[] nums) {
        int totSum=0;
    int n = nums.length;
    for(int i=0; i<n;i++){
        totSum+= nums[i];
    }
    
    if (totSum%2==1) return false;
    
    else{
        int k = totSum/2;
        int dp[][]=new int[n][k+1];
        for(int row[]: dp)
        Arrays.fill(row,-1);
        return solve(n-1,nums,k,dp);
    } 
        
       
    }
    
    public boolean solve(int index, int[] nums, int sum, int dp[][]) {
        
        if(sum ==0)
            return true;
        
        if(index==0)
            return (nums[0] == sum);
        
        if(dp[index][sum] != -1)
            return dp[index][sum] ==0 ? false : true;
        
        
        boolean notTake = solve(index-1, nums, sum, dp);
        
        boolean take = false;
        
        if(nums[index]<=sum)
            take = solve(index-1, nums, sum-nums[index], dp);
        
        dp[index][sum] =  take || notTake ? 1 : 0;
        
        return take || notTake;
    }
}