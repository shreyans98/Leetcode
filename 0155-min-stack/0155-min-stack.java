class MinStack {
    //using 2 stacks
    Stack<Integer> st1;
    Stack<Integer> st2;

    public MinStack() {
        st1 = new Stack<Integer>();
        st2 = new Stack<Integer>();
        
    }
    
    public void push(int val) {
        st1.push(val);
        
        if(st2.size() ==0 || val <= st2.peek())
            st2.push(val);
        
        
    }
    
    public void pop() {
        int data = st1.pop();
        
        if(data == st2.peek())
            st2.pop();
        
        
    }
    
    public int top() {
        return st1.peek();
        
    }
    
    public int getMin() {
        return st2.peek();
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */