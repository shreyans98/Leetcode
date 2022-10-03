class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0, i=0, fcount=0,j=0;
        
        while(i<nums.length) {
            while(i<nums.length && nums[i] != 1) //to find next 1
                i++;
            j=i;
            while(j<nums.length && nums[j] ==1) //to find next 0
                j++;
            count = j-i;
            
            fcount = Math.max(fcount, count);
            i=j;
        }
        
        return fcount;
        
    }
}