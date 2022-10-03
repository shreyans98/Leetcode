class Solution {
    public int[] twoSum(int[] nums, int target) {
        
//Brute force approach by computing every combination
        int count=0;
        int res[] = new int[nums.length];
        for(int i=0;i<nums.length-1;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if(nums[i] + nums[j] == target){
                    res[count] = i;
                    ++count;
                    res[count] = j;
                }
            }
        }
        int fres[] = new int[count+1];
        
        for(int i=0;i<=count;i++){
            fres[i] = res[i];
        }
        
        return fres;
    }
}