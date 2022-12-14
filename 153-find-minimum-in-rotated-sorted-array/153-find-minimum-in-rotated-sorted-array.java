class Solution {
    public int findMin(int[] nums) {
        
        int res = nums[0];
        int left = 0;
        int right = nums.length-1;
        
        while(left<=right) {
            //if array is already sorted, then minimum of the condition
            if(nums[left]<nums[right]){
                res = Math.min(nums[left], res);
                break;
            }
            
            int mid = left + (right-left)/2;
            
            res = Math.min(res, nums[mid]);
            
            if(nums[mid]>=nums[left])
                left = mid+1;
            else
                right = mid-1;
        }
        
        return res;
        
    }
}