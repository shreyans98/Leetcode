class Solution {
    public int splitArray(int[] nums, int k) {
        int max = 0;
        int sum = 0;
        
        for(int i=0;i<nums.length;i++){
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }
        
        int left = max; //maximum value in nums, this is the smallest value we can return 10
        int right = sum; //maximum value that we can return in nums 32
        
        int res = right; //worst case scenario will be when the whole array itself is the sub array which returns the sum
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            
            if (canSplit(mid, k, nums)) {
                res = mid;
                right = mid-1;
            }
            
            else
                left = mid+1;
        }
        
        return res;
        
    }
    
    public boolean canSplit(int mid, int k, int[] nums) {
        int subArray = 1;
        int currSum = 0;
        
        for(int i : nums) {
            currSum += i;
            if(currSum > mid){
                subArray++;
                currSum = i;     
            }
        }
        
        return subArray <=k;
    }
}