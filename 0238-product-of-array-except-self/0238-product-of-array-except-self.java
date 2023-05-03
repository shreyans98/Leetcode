class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int len = nums.length;
        int res[] = new int[len];
        
        Arrays.fill(res, 1);
        int left =1, right =1;
        
        for(int i=0;i<len;i++) {
            res[i] *= left;
            left *= nums[i];
        }
        
        for(int j=len-1;j>=0;j--) {
            res[j] *= right;
            right *= nums[j];
        }
        
        return res;
        
    }
}