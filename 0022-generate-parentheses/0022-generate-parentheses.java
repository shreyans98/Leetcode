class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> output_arr = new ArrayList<String>();
        backtrack(output_arr,"", 0, 0, n);
        return output_arr;
        
    }
    
    public void backtrack(List<String> output_arr, String current_string,int open, int close, int max) {
        
        //base case
        if(current_string.length() == max * 2) {
            output_arr.add(current_string);
            return;
        }
        
        //Decision making for backtracking
        
        //first add open paranthesis as open will be present before close
        if(open < max)
            backtrack(output_arr, current_string+"(", open+1, close, max);
        
        //add closing paranthesis as close cannot come before open
        if(close<open)
            backtrack(output_arr, current_string+")", open, close+1, max);
        
    }
}