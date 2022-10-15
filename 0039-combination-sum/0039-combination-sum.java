class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
       //main list which will contain the final result 
       List<List<Integer>> res = new ArrayList<>();
      
    //sub list which will contain the numbers whose sum is equal to target
       List<Integer> sub = new ArrayList<>();
        
        //method for finding the sum
       backtrack(res, sub, candidates, target,0);
        
        return res;
        
    }
    
    public void backtrack(List<List<Integer>> res, List<Integer> sub, int[] arr, int target,int index) {
        //base case when we reach the end of the array or when sum is equal to targer
        if(index == arr.length) {
            if(target ==0) {
                res.add(new ArrayList<>(sub));
            }
            return;
        }
        //if arr[index] is less or equal to target then only we will go for the operation of adding it to list
        if(arr[index] <= target) {
            sub.add(arr[index]);
            backtrack(res, sub, arr, target-arr[index], index);
            //we will remove the present added number so that we don't get redundant lists
            sub.remove(sub.size()-1);
        }
        //
        backtrack(res, sub, arr, target, index+1);
        
    }
    
}