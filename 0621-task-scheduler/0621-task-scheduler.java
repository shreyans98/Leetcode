class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int char_counts[] = new int[26];
        for(char ch : tasks)
            char_counts[ch - 'A']++;
        
        //to get the most frequently used character at last
        Arrays.sort(char_counts);
        //subtracting 1 because we will not leave any idle space at the last place when tasks are scheduled
        int max_count = char_counts[25] - 1;
        
        int idle_slots = max_count * n;
        
        //Minimum of next frequently used task and max_count since there is a possibility that 2 of the most frequent task have the same frequency
        for(int k=24;k>=0;k--) 
            idle_slots -= Math.min(max_count, char_counts[k]);
        
        
        return idle_slots > 0 ? idle_slots+tasks.length : tasks.length;
        
        
        
    }
}