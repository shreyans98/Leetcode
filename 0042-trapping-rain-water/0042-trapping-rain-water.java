class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int left[] = new int[len];
        int right[] = new int[len];
        
        int tWater = 0;
        left[0] = height[0];
        
        right[len-1] = height[len-1];
        
        for(int i=1;i<len;i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }
        
        for(int j=len-2;j>=0;j--) {
            right[j] = Math.max(right[j+1], height[j]);
        }
        
        for(int i=0;i<len;i++) {
            tWater += Math.min(left[i], right[i]) - height[i];
        }
        
        return tWater;
        
    }
}