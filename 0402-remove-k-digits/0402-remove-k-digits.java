class Solution {
    public String removeKdigits(String num, int k) {
        
        int size = num.length();
        
        if(size == k)
            return "0";
        
        Stack<Character> st = new Stack<Character>();
        
        int i = 0;
        
        //greedy approach(if we encounter a number which is smaller then the number at the peek of the stack then we will rmeove the peek and add the smaller number to the peek. We can do this operation k times)
        while(i<size) {
            char ch = num.charAt(i);
            //if stack is not empty and other condition satisfies then we will perform the operation
            while(!st.isEmpty() && st.peek() > ch && k>0){
                st.pop();
                k--;
            }
            
            st.push(ch);
            i++;
        }
        
        //for edge case like 1111, 2222(since above while loop will not work)
        
        while(k>0){
            st.pop();
            k--;
        }
        
        //to build the striing
        
        StringBuilder sb = new StringBuilder();
        
        while(!st.isEmpty()) {
            char current = st.pop();
            sb.append(current);
        }
        
        //to reverse the string, since stack follows LIF0
        sb.reverse();
        //to remove leading zeroes
        while(sb.length() > 1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        
        return sb.toString();
    }
}