class Solution {
    public int removeDuplicates(int[] nums) {
        
        int temp = 0;
        int count = 1;
        
        for(int i=1;i<nums.length;i++) {
            if(nums[i] != nums[temp]){
                nums[count] = nums[i];
                count++;
            }  
                temp++;
        }
        return count;
        
    }
}