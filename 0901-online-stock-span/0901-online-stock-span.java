class StockSpanner {
    Deque<Integer[]> deque;

    public StockSpanner() {
        deque = new ArrayDeque<Integer[]>();
    }
    
    public int next(int price) {
        int days = 1;
        
        while (!deque.isEmpty() && deque.peekLast()[0] <= price) {
            days += deque.removeLast()[1];
        }
        
        deque.addLast(new Integer[] {price, days});
        
        return days;
    }
}
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */