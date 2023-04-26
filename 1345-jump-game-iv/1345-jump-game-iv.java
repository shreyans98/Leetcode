class Solution {
    public int minJumps(int[] arr) {
        
        int len = arr.length;
        if(len == 1)
            return 0;
        
        //created map holding integer value at particular index and index itself
        Map<Integer, List<Integer>> map = new HashMap<>();
        int step =0;
        
        //store everything in the map(number along with its indexes are mapped)
        for(int i=0;i<len;i++) {
            
            map.computeIfAbsent(arr[i], v -> new ArrayList()).add(i);
        }
        
        //we will maintain a queue which stores the indexes which we will travel and everytime we travel an index we increment step by 1
        Queue<Integer> q = new LinkedList<>();
        q.offer(0); //initial position is 0
        
        while(!q.isEmpty()) {
            step++;
            
            int size = q.size();
            
            //iterate through all possible ways available at a particular index and store it in queue
            for(int i=0;i<size;i++) {
                
                int j = q.poll();
                
                if(j-1 >=0 && map.containsKey(arr[j-1])) {
                    q.offer(j-1);
                }
                
                if(j+1 < len && map.containsKey(arr[j+1])) {
                    if(j+1 == len - 1)
                        return step;
                    
                    q.offer(j+1);
                }
                
                // if the map contains the same number then we will iterate through all index which have the same number and add it in quueue if it is not equal to the original index. If at some point we reach last index we will return 1
                if(map.containsKey(arr[j])) {
                    for(int k : map.get(arr[j])) {
                        if(k != j) {
                            if(k == len -1)
                                return step;
                            q.offer(k);
                        }
                    }
                }
                map.remove(arr[j]);
                
            }
        }
        
        return step;
        
    }
}