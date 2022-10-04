class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int perimeter=0;
        
        for(int i=nums.length-1;i>1;i--) {
            if(nums[i] < nums[i-1]+nums[i-2]){
                perimeter = nums[i]+nums[i-1]+nums[i-2];
                return perimeter;
            }
        }
        
        return perimeter;
        
    }
}