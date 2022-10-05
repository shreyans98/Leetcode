class Solution {
    public int maxArea(int[] height) {
        
        int left = 0;
        int right = height.length-1;
        int finalArea = Integer.MIN_VALUE;
        
        int area = 0;
        
        while(left < right) {
            area = ((Math.min(height[left], height[right])) * (right-left));
            
            if(height[left] < height[right])
                left++;
            else if(height[left] > height[right])
                right--;
            else {
                left++;
                right--;
            }
            
            finalArea = Math.max(area, finalArea);
        }
        
        return finalArea;
        
        
    }
}