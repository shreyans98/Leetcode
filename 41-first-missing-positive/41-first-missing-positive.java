class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int correct_pos = 0;
        int temp = 0;
        
        for(int i=0;i<nums.length;i++) {//loop to iterate through all values and determine its correct position
            correct_pos = nums[i]-1;
    //in this loop we will start with swap only for those values which are in between 1 to nums.length() since 1 will be the smallest possible integer and nums.length() + 1 is the worstt case possible integer. Last and condition in the below line will be for scenario where we have to swap more than once for a value.
            while(nums[i] >=1 && nums[i] < nums.length && nums[i] != nums[correct_pos]){
                temp = nums[i];
                nums[i] = nums[correct_pos];
                nums[correct_pos] = temp;
                
                //this line will change the correct position since nums[i] has changed
                correct_pos = nums[i]-1;
            }
        }
        
        //in this loop we will iterate through the array again and we will take those index which does not have the same value as index itself and hence this will show the first possible smallest integer
        for(int i=0;i<nums.length;i++) {
            if(i+1 != nums[i])
                return i+1;
        }
      return nums.length+1;

    }
}