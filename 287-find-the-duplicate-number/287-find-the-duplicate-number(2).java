class Solution {
    public int findDuplicate(int[] nums) {
        
        //using Set(brute force approach)
        Set<Integer> seen = new HashSet<Integer>();
        for(int num : nums) {
            if(seen.contains(num))
                return num;
            seen.add(num);
        }
        return -1;
    }
}
