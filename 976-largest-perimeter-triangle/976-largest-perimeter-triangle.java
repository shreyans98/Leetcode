class Solution {
    public int largestPerimeter(int[] nums) {

//We will sort the array and then start from the back since the greatest perimeter of triangle will comprise of maximum length of the sides.        
        Arrays.sort(nums);
        int perimeter=0;
        
        for(int i=nums.length-1;i>1;i--) {
            if(nums[i] < nums[i-1]+nums[i-2]){
                perimeter = nums[i]+nums[i-1]+nums[i-2];//we will return the perimeter in the first time we get a value since it will be the maximum
                return perimeter;
            }
        }
        
        return perimeter;
        
    }
}