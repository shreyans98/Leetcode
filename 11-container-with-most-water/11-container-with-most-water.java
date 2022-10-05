class Solution {
    public int maxArea(int[] height) {
        
/*
Intution behind the approach is to find the area for every index.
Height of every index will be the minimum of two index from both sides, and width can be maximised in this respect.

When height on the left side is smaller than the height on the right side then we have to move the index on this side as the maximum area for this index is achieved. 

Similarly for the right side we will move to the left side.
*/        
        int left = 0;
        int right = height.length-1;
      //  int finalArea = Integer.MIN_VALUE;
        
        int area = 0;
        
        while(left < right) {
            area = Math.max(((Math.min(height[left], height[right])) * (right-left)), area);
            
            if(height[left] < height[right])
                left++;
            else if(height[left] > height[right])
                right--;
            else {
                left++;
                right--;
            }
            
           // finalArea = Math.max(area, finalArea);
        }
        
        return area;
        
        
    }
}