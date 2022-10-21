class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        
        for(int i=0;i<nums.length;i++) {
            pq.offer(new int[] {nums[i], i});
            
            if(pq.size() > k)
                pq.poll();
        }
        
        //set to keep unique index
        Set<Integer> set = new HashSet<>();
        
        while(! pq.isEmpty()) {
            int top[] = pq.poll();
            set.add(top[1]);
            
        }
        
        int arr[] = new int[k]; //to store the final result
        
        int counter = 0;
        
        for(int j=0;j<nums.length;j++) {
            
            if(set.contains(j)) {
                arr[counter] = nums[j];
                counter++;
            }
            
        }
            
        return arr;
            
        
    }
}