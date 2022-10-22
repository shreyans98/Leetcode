class MedianFinder {
    /*
    2 priority queue to divide the array into 2 parts.
    The small priority queue is sorted in descending order and the large one in ascending order.
    
    Small priority queue will have always k elements and will be equal or less in size then the large priority     queue. Both can have the same element or the small queue will have one extra element.
    
    When both have the same element, then we will enter the num in the large heap and pop the max element from     it and then push that element to the small heap.
    
    When large heap has more element then we will enter the value in the small heap first
    
    
    */
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
        
        small.offer(num);
        large.offer(small.poll());
        
        if(small.size() < large.size())
            small.offer(large.poll());
        
        
    }
    
    public double findMedian() {
        
        if(small.size() == large.size())
            return (small.peek() + large.peek())/2.0;
        else
            return small.peek();
        
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */