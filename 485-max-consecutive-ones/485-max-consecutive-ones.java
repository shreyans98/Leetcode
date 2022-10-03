class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int fcount = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++) {
            
            //if nums[i] = 0, the streak of consecutive 1's breaks and hence count is returned to 0, with fcount storing the final count of consecutive 1's
            count = (nums[i] == 0) ? 0 : count +1;
             
            fcount = Math.max(fcount, count);
        }
        
        return fcount;
        
    }
}