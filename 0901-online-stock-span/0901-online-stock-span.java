class StockSpanner {
    
    Stack<Pair<Integer, Integer>> st;

    public StockSpanner() {
        
        st = new Stack<>();
        
    }
    
    public int next(int price) {
        
        int val = 1;
        
        while(!st.isEmpty() && st.peek().getKey() <= price)
            val += st.pop().getValue();
        
        Pair<Integer, Integer> p = new Pair<>(price, val);
        st.push(p);
        
        return p.getValue();
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */