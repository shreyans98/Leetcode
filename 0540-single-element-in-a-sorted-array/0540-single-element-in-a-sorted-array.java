class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        
        /*
        So the algorithmic approach will be to use binary search. The intuition is that when we see an element, if we know its index and whether it is the first instance or the second instance, we can decide whether we are presently in the left array or right array. Moreover, we can decide which direction we need to move to find the breakpoint. We need to find this breakpoint between our left array and the right array.

We will check our mid element, if it is in the left array, we will shrink our left array to the right of this mid element, if it is in the right array, we will shrink the right array to the left of this mid element. This binary search process will continue till the right array surpasses our left one and the low is pointing towards the breakpoint.
        
        
        */
        int low = 0;
        int high = nums.length-2;
        
        while(low <= high) {
            int mid = (low+high)/2;
            
            if(mid % 2 ==0) {
                //checking whether we are in right half
                if(nums[mid] != nums[mid+1])
                    //shrink the right half
                    high = mid-1;
                else
                    //shrink the left half
                    low = mid+1;
            }
            
            else {
                //checking whether we are in right half
                if(nums[mid] == nums[mid+1])
                    //shrinking the right half
                    high = mid-1;
                else
                    //shrinking the left half
                    low = mid+1;
            }
        }
        
        return nums[low];
        
    }
}