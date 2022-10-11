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
//we will take the midle element as the maximized sum for refrence
            int mid = left + (right - left)/2;
            
            if (canSplit(mid, k, nums)) { //this function will check if we can get the value greater than sum of subarray
                res = mid; //if possible then our mid will be the minimized max sum
                right = mid-1; //we subtract right, since we need to further check if sum can be minimized further
            }
            
            else
                left = mid+1; //if not a subarray then we have to increase
        }
        
        return res;
        
    }
    
    public boolean canSplit(int mid, int k, int[] nums) {
        int subArray = 0; 
        int currSum = 0; //sum of sub array
        
        for(int i : nums) {
            currSum += i;
            if(currSum > mid){ //if subarray is greater that means we have a subarray that is greater than minimum larget sum
                subArray++;
                currSum = i; //we do this as after adding i only we exceeded the mid point hence we want this i to be the part of the sum of next subarray instead of previous 1    
            }
        }
        
        return subArray+1 <=k; //we are adding 1 to subarray because after creating a second subarray only we are adding the subarray count hence there might be a possibility that the value of last subarray might be less than mid and hence count might not increament, hence we add 1 to compensate for that.
    }
}