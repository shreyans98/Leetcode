class Solution {
    
    HashSet<List<Integer>> res = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        boolean vis[] = new boolean[len];
        dfs(new ArrayList<Integer>(), nums, vis);
        return new ArrayList(res);
        
    }
    
    public void dfs(List<Integer> path, int nums[], boolean vis[]) {
        
        if(path.size() == nums.length) {
            res.add(new ArrayList<Integer> (path));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            
            if(!vis[i]) {
                path.add(nums[i]);
                vis[i] = true;
                dfs(path, nums, vis);
                path.remove(path.size()-1);
                vis[i] = false;
            }
        }
    }
}