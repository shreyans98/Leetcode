class Solution {
    public boolean canPartition(int[] nums) {
       
        int sum = 0;
        
        for(int arr=0;arr<nums.length;arr++)
            sum += nums[arr];
        
        if(sum % 2 ==1)
            return false;
        
        else {
            
             int len = nums.length;
             int k = sum/2;
             int dp[][] = new int[len][k+1];
        
             for(int arr[]: dp)
            
                 Arrays.fill(arr, -1);
        
             return solve(len-1, nums, k, dp);
            
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