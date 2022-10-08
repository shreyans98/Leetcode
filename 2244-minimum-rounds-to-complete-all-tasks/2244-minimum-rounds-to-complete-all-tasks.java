class Solution {
    public int minimumRounds(int[] tasks) {
        
        int days = 0;
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        

        for(int i:tasks)
            hmap.put(i, hmap.getOrDefault(i,0)+1);
        
        for(int i: hmap.values()) {

            if(i==1)
                return -1;
            
            if(i%3 == 0)
                days += i/3;
            else if(i % 3 ==1)
                days += (i-4)/3 +2;
            else if(i %3 == 2)
                days += i/3 +1;
           // else if(i%2)
        }
        
        return days;
        
        
    }
}