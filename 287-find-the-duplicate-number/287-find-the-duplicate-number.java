class Solution {
    public int findDuplicate(int[] nums) {
        
        // find the intersection point of the two runners.
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while(slow != fast);
        
        //to find the entrance to the cycle
        fast = nums[0];
        
        while(fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
        
    }
}