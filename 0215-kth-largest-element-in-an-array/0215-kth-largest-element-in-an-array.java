class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        /*
        Design a min heap(root will be the minimum of all elements in array)
        
        as soon as size of min heap crosses k, start popping values from min heap after the whole iteration is completed, we will have the kth largest element as the root of the min heap, since we have removed elements from heap after it attains the size greater than k.
        
        */
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int i: nums) {
            pq.add(i);
            
            if(pq.size() > k)
                pq.poll();
        }
        
        return pq.poll();
        
    }
}