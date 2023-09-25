class Solution {
    long maxProduct = 0;
    public long maxStrength(int[] nums) {
        
        int length = nums.length;
        if(length == 1)
            return nums[0];
        
        int positiveNum = 0, negativeNum =0, zeroNum = 0;
        for(int num : nums) {
            if(num > 0)
                positiveNum++;
            else if(num < 0)
                negativeNum++;
            else
                zeroNum++;
        }
        
        //it means there is 1 negative number and rest all are 0
        if(positiveNum == 0 && negativeNum == 1 && length > 1)
            return 0;
        
        if(zeroNum == length)
            return 0;
        
        calculate(nums, 0, 1);
        
        return maxProduct;
        
    }
    
    public void calculate(int nums[], int i, long grp) {
        
        if(i >= nums.length) {
            maxProduct = Math.max(maxProduct, grp);
            return;
        }
        
        calculate(nums, i+1, grp*nums[i]);
        calculate(nums, i+1, grp);
    }
}