class Solution {
    public int missingNumber(int[] nums) {
        
        int len = nums.length;
        int naturalSum = (len * (len+1))/2;
        
        int actualSum = Arrays.stream(nums).sum();
        
        return naturalSum - actualSum;
        
    }
}