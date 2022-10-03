class Solution {
    public int trap(int[] height) {
        
        //To decrease the time complexity we can calculate the left max and right max before hand and store it in a separate array.
         int n = height.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int tWater = 0;
        
        
        left[0] = height[0];
        //loop to calculate the left max for each element
        for(int i=1;i<n;i++)
            left[i] = Math.max(left[i-1], height[i]);
        
        right[n-1] = height[n-1];
        //loop to calculate the right max for each element
        for(int j=n-2;j>=0;j--)
            right[j] = Math.max(right[j+1], height[j]);
        
        //loop to calculate the trapped water
        for(int i=0;i<n;i++) {
            tWater += Math.min(left[i], right[i])- height[i];
        }
        
        return tWater;
    }
}