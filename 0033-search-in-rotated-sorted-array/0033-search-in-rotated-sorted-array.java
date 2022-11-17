class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high) {
            int mid = (low + high)/2;
            
            if(nums[mid] == target)
                return mid;
            
            //to check if the left part is sorted or not
            if(nums[low] <= nums[mid]) {
                //if left part is sorted we will check in which range does target lies, if it is within range then we decrease high and if it is not then we search for it from the middle element to the last
                if(nums[low] <= target && target <= nums[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }
            
            //if left part is unsorted then we check for tha range of target and reduce low/high accordingly 
            else {
                if(nums[mid] <= target && target <= nums[high])
                    low = mid+1;
                else 
                    high = mid - 1;
            }
        }
        
        return -1;
    }
}