class Solution {
    public int firstMissingPositive(int[] nums) {
        
        //we are using set here since set in java does not contain duplicate value, so even if a number occurs multiple times we will add to the set only once.
        Set<Integer> count = new HashSet<>();
        
        //add all the numbers to the set
        for(int i=0;i<nums.length;i++)
            count.add(nums[i]);
        
        //traverse through the set to get the smalllest integer which is not present.
        int i=1;
        while(count.contains(i)) {
            i++;
        }
        return i;
        
    }
}