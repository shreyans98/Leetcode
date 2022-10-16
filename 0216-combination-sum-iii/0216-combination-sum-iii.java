class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        //brute force approach
        
        List<List<Integer>> res = new ArrayList<>();
        
        List<Integer> sub = new ArrayList<>();
        
        recurse(res, sub, k, n, 1);
        
        return res;
        
    }
    
    public void recurse(List<List<Integer>> res, List<Integer> sub, int k, int n, int start) {
        //Only when k numbers are used and n is 0 then add it to list
        if(n==0 && k==sub.size()) { 
            res.add(new ArrayList<>(sub));
            return;
        }
        
            //start will change with every recursion call since we have to use a number atmost once
            for(int i=start;i<=9;i++){
                sub.add(i);
                recurse(res, sub,k,n-i,i+1);
                
                //not pick then remove it to proceed with  this set of recursion
                sub.remove(sub.size() - 1);
            }

    }
}