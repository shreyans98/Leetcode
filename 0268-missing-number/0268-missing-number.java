class Solution {
    public int missingNumber(int[] nums) {
        
        int len = nums.length;
        int arr[] = new int[len+1];
        
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++) {
            arr[nums[i]] = -1;
        }
        
        int result =0;
        
        for(int i=0;i<arr.length;i++) {
            if(arr[i] != -1) 
                result = i;
        }
        
        return result;
        
    }
}