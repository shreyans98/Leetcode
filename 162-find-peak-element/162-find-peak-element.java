class Solution {
    public int findPeakElement(int[] nums) {
        
        int low = 0;
        int high = nums.length-1;
        
        int index = 0;
        if(nums.length ==1 || nums.length ==0)
            return 0;
        
        while(low <= high) {
            if(nums[low] < nums[low+1])
                low++;
            else 
                return low;
            
            
            if(nums[high] < nums[high-1])
                high--;
            else 
                return high;
            
        }
        
        return 0;
    }
}