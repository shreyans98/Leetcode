class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        //to store the final subset
        List<List<Integer>> res = new ArrayList<>();
        
        //to store the current subset
        List<Integer> list = new ArrayList<>();
        
        backtrack(res, list, nums,0);
        
        return res;
        
    }
    
    public void backtrack(List<List<Integer>> res, List<Integer> list, int nums[], int index) {
        
        //base condition
        if(index >= nums.length)
            res.add(new ArrayList<>(list));
            
        else {
            //pick condition
            list.add(nums[index]);
            
            backtrack(res, list, nums, index+1);
            
            //backtracking to remove the last number
            list.remove(list.size()-1);
            
            //not pick condition
            
            backtrack(res, list, nums, index+1);
            
        }
    }
}