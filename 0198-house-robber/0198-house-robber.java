class Solution {
    public int rob(int[] nums) {
        int rob = 0; //if we rob the house
        int notRob=0; //if we do not rob the house
        
        for(int i=0;i<nums.length;i++) {
            int curRob = notRob + nums[i]; //if we rob current house it means previous house is not robbed
    notRob = Math.max(notRob, rob); //if we do not rob it then we take max value of robbed i-1 house and not rob i-1 hous
            rob = curRob;
        }
        
        return Math.max(rob, notRob);
        
    }
}