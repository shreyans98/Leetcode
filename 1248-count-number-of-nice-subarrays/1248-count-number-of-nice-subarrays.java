class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
        
    }
    
    private int helper(int[] nums, int t) {
        int res=0, count=0, start =0;
        
        for(int end=0;end<nums.length;end++) {
            t -= nums[end] %2;
            
            while(t<0){
                t += nums[start++] % 2 ==0 ? 0 : 1;
            }
            
            res += end-start+1;
        }
        return res;
    }
}