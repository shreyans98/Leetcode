class Solution {
    public void sortColors(int[] nums) {
        //Keep count of values and overwrite the array accordingly
        
        int ct_0 = 0, ct_1 = 0, ct_2 = 0;
        
        for(int i=0;i<nums.length;i++) {
            if(nums[i] ==0)
                ct_0++;
            else if(nums[i] ==1)
                ct_1++;
            else
                ct_2++;
        }
        for(int i=0;i<nums.length;i++) {
            if(ct_0>0){
                nums[i]=0;
                ct_0--;
            }
            else if(ct_1>0){
                nums[i]=1;
                ct_1--;
            }
            else
                nums[i]=2;
            
        }
        
    }
}
