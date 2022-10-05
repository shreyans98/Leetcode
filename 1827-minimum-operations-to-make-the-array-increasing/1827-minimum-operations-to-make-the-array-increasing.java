class Solution {
    public int minOperations(int[] nums) {
        int minOpt = 0;
        int i=1;
        
        if(nums.length ==0 || nums.length ==1)
            return 0;
        
        while(i<nums.length){
            if(nums[i-1]<nums[i])
                i++;
            else{
                minOpt++;
                nums[i]++;
            }
        }
        return minOpt;
    }
}