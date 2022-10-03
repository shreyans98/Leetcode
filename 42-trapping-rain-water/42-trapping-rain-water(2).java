class Solution {
    public int trap(int[] height) {

//Approach here is that for every index the water trapped is minimum of maximum elevation to the left and minimum of maximum elevation to the right minus the index value        
        
        
        
        int leftMax = 0, rightMax = 0;
        int tWater = 0;
        int j = 0;
        
        for(int i=0;i<height.length;i++) {
            leftMax = 0; rightMax = 0;
            
            j = i;
            
            //loop to find the maximum index value on left side
            while(j>=0) {
                leftMax = Math.max(leftMax, height[j]);
                j--;
            }
            
            j = i;
            //loop to find the maximum index value to the right side
            while(j<height.length) {
                rightMax = Math.max(rightMax, height[j]);
                j++;
            }
            
            //minimum of both the maximum's minus the value of that index
            tWater += Math.min(leftMax, rightMax) - height[i];
            
        }
        
        return tWater;
        
    }
}
