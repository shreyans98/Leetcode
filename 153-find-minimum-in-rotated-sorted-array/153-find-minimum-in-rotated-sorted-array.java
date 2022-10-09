class Solution {
    public int findMin(int[] nums) {
        
        int first = 0;
        int last = nums.length-1;
        int temp = 0;
        int mid = 0;
        if(nums[last]> nums[0] || nums.length ==1)
            return nums[0];
        
        while(first<=last) {
            mid = first + (last-first)/2;
            
            if(nums[mid] > nums[mid+1])
                return nums[mid+1];
            
            if(nums[mid] < nums[mid-1])
                return nums[mid];
            
            if(nums[mid] > nums[0])
                first = mid+1;
            else
                last = mid-1;
        }
        return 1;
    }
}