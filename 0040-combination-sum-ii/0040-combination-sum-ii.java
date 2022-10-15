class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> sub = new ArrayList<>();
        
        backtrack(res, sub, candidates, target, 0);
        
        
        return res;
        
    }
    
    public void backtrack(List<List<Integer>> res, List<Integer> sub, int arr[], int target, int index) {
        
        
        if(target ==0){
            res.add(new ArrayList<>(sub));
            return;
            
        }
        
            for(int i=index;i<arr.length;i++) {
                if(i > index && arr[i] == arr[i-1]) continue;
                if(arr[index]>target) break;
                
                
                sub.add(arr[i]);
                backtrack(res, sub, arr, target-arr[i], i+1);
                sub.remove(sub.size() - 1);
            }
    
    }
}