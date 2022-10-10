class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        
        int low = 1;
        int high = 1000000;
        
        while(low<=high) {
            int mid = (low + high)/2;
            int div = 0;
            
            for(int i=0;i<nums.length;i++){
                 div += Math.ceil(1.0 * nums[i] / mid);
            }
            
            if(div > threshold)
                low = mid+1;
            else
                high = mid-1;
        }
        
        return low;
        
    }
}