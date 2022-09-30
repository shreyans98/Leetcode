class Solution {
    public void sortColors(int[] nums) {
        //Keep count of values and overwrite the array accordingly
        
        int ct_0 = 0, ct_1 = 0, ct_2 = 0;
        
        for(int i=0;i<nums.length;i++) { //loop to keep a count of values
            switch(nums[i]) {
                case 0:  //for number of 0's
                    ct_0++;
                    break;
                case 1: //for number of 1's
                    ct_1++;
                    break;
                case 2: //for number of 2's
                    ct_2++;
                    break;
            }
        }
        for(int i=0;i<nums.length;i++) { //loop to overwrite the results
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
