class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int res = Integer.MAX_VALUE, start = 0;
        
        //start subtracting from the target
        for(int end = 0;end<nums.length;end++) {
            target -= nums[end];
            
            //we will keep reducing the size of the window till we reach near the target as we want to get the minimum length of the subarray
            while(target <= 0){
                res = Math.min(res, end-start+1);
                target += nums[start++];
                
            }
            
            
        }
        
        return res == Integer.MAX_VALUE ? 0 : res;
        
    }
}