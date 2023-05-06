class Solution {
    public void rotate(int[] nums, int k) {
        
        int len = nums.length;
        k = k % len;
        
        help(nums, 0, len-k-1);
        help(nums, len-k, len-1);
        help(nums, 0, len-1);
        
    }
    
    public void help(int nums[], int left, int right) {
        
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}