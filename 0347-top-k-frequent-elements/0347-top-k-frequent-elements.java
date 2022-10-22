class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        //HashMap to store the frequency of the elements
         Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) 
            map.put(num, map.getOrDefault(num, 0) + 1); 
        
        //Priority queue with max heap so that the most frequent element remains at the top
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        
        //max heap
        for(int key : map.keySet()) 
            heap.add(key); 
        
        //list to store the numbers
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < k; i++)
            ans.add(heap.poll());
        
        
        //convert arraylist to array
        int[] arr = new int[ans.size()];
        int i = 0;
        for (Integer e : ans)
            arr[i++] = e;
        return arr;
        
    }
}