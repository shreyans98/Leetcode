class Solution {
    public int minOperations(int[] nums) {
        int minOpt = 0;
        int i=1;
        int temp = 0;
        
        if(nums.length ==1)
            return 0;
        
        while(i<nums.length){
            temp =0;
            if(nums[i-1]<nums[i])
                i++;
            else{
                temp = nums[i-1] + 1;
                minOpt += (temp-nums[i]);
                nums[i] = temp;
            }
        }
        return minOpt;
    }
}