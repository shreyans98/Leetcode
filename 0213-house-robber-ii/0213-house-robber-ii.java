class Solution {
    public int rob(int[] nums) {
        if(nums.length ==1)
            return nums[0];
        
        return Math.max(solve0(nums), solve1(nums));
        
    }
    
    public int solve0(int nums[]) {
        int rob = 0;
        int notRob = 0;
        
        for(int i=0;i<nums.length-1;i++) {
            int curRob = notRob + nums[i];
            notRob = Math.max(notRob, rob);
            rob = curRob;
        }
        
        return Math.max(rob, notRob);
    }
    
    public int solve1(int nums[]) {
        int rob = 0;
        int notRob = 0;
        
        for(int i=1;i<nums.length;i++) {
            int curRob = notRob + nums[i];
            notRob = Math.max(notRob, rob);
            rob = curRob;
        }
        
        return Math.max(rob, notRob);
    }
}