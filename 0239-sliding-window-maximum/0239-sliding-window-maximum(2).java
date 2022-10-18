class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //brute force approach
        int len = nums.length;
        if(len ==0)
            return new int[0];
        //we add 1 at last because leaving k elements will prevent 1 window hence at max we can skip k-1 elements if we calculate including the length of the array
        int windows = len-k+1;
        //number of windows we will have that many max elements
        int res[] = new int[windows];
        
        //traverse till the first element of last window
        for(int start=0;start<windows;start++) {
            int max = nums[start];
            int end = start+k;
            //loop to find max
            for(int j=start;j<end;j++){
                max = Math.max(max, nums[j]);
            }
            
            res[start] = max;
        }
        
        return res;
        
        
    }
}
