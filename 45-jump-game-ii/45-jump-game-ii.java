class Solution {
    public int jump(int[] nums) {
        
/*
Intution behind the approach is to calculate the maximum step at each index within the range of the previous index. 

Here, range is the number of next indexes we can jump from a particular index

*/
        int left = 0, right = 0;
        int steps = 0;
        
        while(right < nums.length-1) {
            int farthest = 0;
            
            for(int i=left;i<right+1;i++)
                farthest = Math.max(farthest, i+nums[i]);
            
            left = right + 1;
            right = farthest;
            steps += 1;
            
        }
        return steps;
    }
}