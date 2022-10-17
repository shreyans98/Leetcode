class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<Character>();
        
        if(s.charAt(0) ==')' || s.charAt(0) =='}' || s.charAt(0) == ']')
            return false;
        
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            
            switch(ch) {
                case '(':
                case '[':
                case '{':
                    st.push(ch);
                    break;
                
                case ')':
                     if(st.isEmpty())
                    return false;
                if(st.pop() !='(')
                    return false;   
                    break;
                    
                     case ']':
                     if(st.isEmpty())
                    return false;
                if(st.pop() !='[')
                    return false;   
                    break;
                    
                     case '}':
                     if(st.isEmpty())
                    return false;
                if(st.pop() !='{')
                    return false;   
                    break;
                    
            }
            
//             if(ch == '(' || ch == '{' || ch == '[')
//                 st.push(ch);
            
//             else if(ch == ')'){
//                 if(st.isEmpty())
//                     return false;
//                 if(st.pop() !='(')
//                     return false;      
//             }
            
//             else if(ch == ']'){
//                 if(st.isEmpty())
//                     return false;
//                 if(st.pop() !='[')
//                     return false;      
//             }
            
//             else if(ch == '}'){
//                 if(st.isEmpty())
//                     return false;
//                 if(st.pop() !='{')
//                     return false;      
//             }
            
            
           
            
        }
        return st.isEmpty();
    }
}