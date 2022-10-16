class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<>();
        
        List<Integer> sub = new ArrayList<>();
        
        backtrack(res, sub, nums, 0);
        
        return res;
        
    }
    
    public void backtrack(List<List<Integer>> res, List<Integer> sub, int arr[], int index) {
        
        //base case
        res.add(new ArrayList<>(sub));
        
        for(int i=index;i<arr.length;i++) {
            if(i > index && arr[i] == arr[i-1])
                continue;
            sub.add(arr[i]);
            backtrack(res, sub, arr, i+1);
            sub.remove(sub.size()-1);
            //backtrack(res, sub, arr, i+1);


        }

        

    }
}