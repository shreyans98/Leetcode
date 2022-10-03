class Solution {
    public int removeDuplicates(int[] nums) {
        
        int temp = 0; //variable for maintaining the latest element to be exhanged
        int count = 1; //variable to maintain the position of newly entered element
        
        for(int i=1;i<nums.length;i++) {
            if(nums[i] != nums[temp]){ //if not equal, it means unique value hence we enter the element and upgrade count
                nums[count] = nums[i];
                count++;
            }  
                temp++; //else upgrade the element which is latest and to be exchanged
        }
        return count;
        
    }
}