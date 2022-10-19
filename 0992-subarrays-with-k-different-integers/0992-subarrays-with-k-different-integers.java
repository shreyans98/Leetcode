class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return helper(nums, k) - helper(nums, k-1);
        
    }
    
    private int helper(int nums[], int k) {
        int res=0;
        int start = 0;
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int end=0;end<nums.length;end++) {
            if(map.getOrDefault(nums[end], 0) ==0)
                k--;
            
            
            map.put(nums[end], map.getOrDefault(nums[end], 0)+1);
            
            while(k < 0) {
                map.put(nums[start], map.get(nums[start])-1);
                if(map.get(nums[start])==0)
                    k++;
                start++;
            }
            
            res += end-start+1;
        }
        
        return res;
        
        
    }
}