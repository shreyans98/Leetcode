class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        return helper(nums, goal) - helper(nums, goal-1);
        
        
        
    }
    
    private int helper(int nums[], int target) {
        
        if(target < 0)
            return 0;
        
        int res = 0, start = 0;
        
        for(int end=0;end<nums.length;end++) {
            target -= nums[end];
            
            while(target < 0)
                target += nums[start++];
            
            res += end-start+1;
            
        }
        return res;
    }
}