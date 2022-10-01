class Solution {
    public int[][] merge(int[][] intervals) {
        
//First sort the interval so as tp make the array sorted for easy sorting procedure in further steps
        
        Arrays.sort(intervals, (a, b) -> (a[0]-b[0]));
        
        //data structure initialised to store the final interval list
        ArrayList<int []> result = new ArrayList<>();
        
        //now we have the sorted array, hence traverse through it and if the number appears in-between the next interval of numbers take the latest interval otherwise just add it.
        
        for(int i=0;i<intervals.length;i++) {
    //we will add the first number of array list since the new interval will start from this
            if(i==0) 
                result.add(intervals[i]);
            
            //get the latest element from the result list
            int[] prev = result.get(result.size()-1);    
            
            //get the current interval of original intervals array
            int[] curr = intervals[i];
            
             // The new interval should cover both events
             // So it has an smallest start time and largest end time
             // Since it's the interval in result that overlaps with our new
             // interval, we just modify that interval in result
             // (it's guarantee that start time of prev is smaller or equal
             // to that of curr since we traverse a sorted array)
            if(prev[1]>=curr[0])
                prev[1] = Math.max(prev[1], curr[1]);
            
            else
                result.add(curr);
        }
        
        return result.toArray(new int[result.size()][2]);
        
    }
}