class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int low = 0;
        int high = nums.length-1;
        int[] arr = new int[2];
        
        arr[0] = -1;
        arr[1] = -1;
        
        
        
        while(low<=high) {
            int mid = low + (high-low)/2;
            
            if(nums[mid] == target){
                arr[0] = mid;
                high = mid-1;
                
            }
                
            
            else if(nums[mid] < target)
                low = mid+1;
            else if(nums[mid] > target)
                high = mid-1;
        }
        
        if(arr[0] ==-1)
            return arr;
        
        
        low = 0;
        high = nums.length-1;
        
        while(low<=high) {
            int mid = low + (high-low)/2;
            
            if(nums[mid] == target) {
                arr[1] = mid;
                low = mid+1;
            }
            
            else if (nums[mid] < target){
                low = mid+1;
            }
            
            else
                high = mid-1;
        }
        
        return arr;
    }
}