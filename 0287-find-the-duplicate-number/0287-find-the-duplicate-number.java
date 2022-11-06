class Solution {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int freq[] = new int[nums.length];
        
        for(int i=0;i<len;i++) {
            if(freq[nums[i]] ==0)
                freq[nums[i]]++;
            else
                return nums[i];
        }
        
        return 0;
        
    }
}