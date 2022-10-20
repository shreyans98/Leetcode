class Solution {
    public int maxProduct(int[] nums) {
        
//This code will also be valid for negative numbers
        
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        
        for(int ch : nums) {
            if(ch > max1) {
                max2 = max1;
                max1 = ch;
            }
            
            else if(ch > max2)
                max2 = ch;
        }
        
        return ((max2-1) * (max1-1));
        
    }
}