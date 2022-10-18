class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int len = nums.length;
        int res[] = new int[len-k+1];
        
        
        //variable to increament the final result array
        int rightIndex = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i=0;i<nums.length;i++) {
            
            //remove numbers out of range fromm front
            if(!dq.isEmpty() && dq.peek() == i-k)
                dq.poll();
            
            //remove smaller elements from last
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();
            
            dq.offer(i);
            
            //to insert into array
            if(i>=k-1)
                res[rightIndex++] = nums[dq.peek()];
            
        }
        
        return res;
        
        
        
    }
}