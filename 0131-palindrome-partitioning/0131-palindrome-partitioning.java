class Solution {
    public List<List<String>> partition(String s) {
        
        //list to store the final answer
        List<List<String>> res = new ArrayList<>();
        //sub list to store individual sub strings
        List<String> sub = new ArrayList<>();
        
        backtrack(res, sub, s, 0);
        
        return res;
        
    }
    
    public void backtrack(List<List<String>> res, List<String> sub, String str, int index) {
        //base case
        if(index >= str.length())
            res.add(new ArrayList<String>(sub));
        
        for(int i=index;i<str.length();i++) {
            if(palindrome(str, index, i)) {//check for palindrome (if true then only below part of code will execute)
                sub.add(str.substring(index, i+1));//add to the list the substring
                backtrack(res, sub, str, i+1);
                //remove the current element as during the other part of decision, that element is excluded
                sub.remove(sub.size() - 1); 
            }
        }
        
    }
    //method to check if palindrome or not
    public boolean palindrome(String rev, int start, int end) {
        while(start < end) {
            if(rev.charAt(start++) != rev.charAt(end--))
                return false;
        }
        
        return true;
    }
}