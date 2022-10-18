class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> st = new Stack<Integer>();
        
        for(int ast: asteroids) {
            //if positive direction then push it
            if(ast > 0)
                st.push(ast);
            
            else {
                //till the stack is not empty and we keep getting smaller asteroids they will be destroyed after popping
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(ast))
                    st.pop();
                
                //if stack becomes empty during pop operations OR thw peek element is also less than 0 means negative, same as presnt asteroid
                if(st.isEmpty() || st.peek() < 0)
                    st.push(ast);
                
                else if(st.peek() == Math.abs(ast))
                    st.pop();
                
            }
        }
        
        int res[] = new int[st.size()];
        
        for(int i= res.length-1;i>=0;i--) {
            res[i] = st.pop();
        }
        
        return res;
            
        
    }
}