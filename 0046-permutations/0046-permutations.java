class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        

        backtrack(res, nums, 0);
        
        return res;
    }
    
    public void backtrack(List<List<Integer>> res, int nums[], int index) {
        if(index == nums.length) {
            List<Integer> ds = new ArrayList<>();

            for(int i=0;i<nums.length;i++) 
                ds.add(nums[i]);
            
            res.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=index;i<nums.length;i++) {
            swap(nums, i, index);
            backtrack(res, nums, index+1);
            swap(nums, i, index);
        }
    }
    
    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}