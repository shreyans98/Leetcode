class Solution {
    public int maxSubArray(int[] nums) {
        //Dynamic Programming approach
        int max_sum = nums[0];
        int res = nums[0];
        
        for(int i=1;i<nums.length;i++) {
            max_sum = Math.max(max_sum + nums[i], nums[i]);
            res = Math.max(res, max_sum);
        }
        
        return res;
    }
}