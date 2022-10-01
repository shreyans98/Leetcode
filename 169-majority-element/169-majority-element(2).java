class Solution {
    public int majorityElement(int[] nums) {
        
        //using HashMap to store the frequency of every element
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for(int num : nums) {
            if(!count.containsKey(num))
                count.put(num, 1);
            else
                count.put(num, count.get(num)+1);
                
        }
        
        Map.Entry<Integer, Integer> majEntry = null;
        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if(majEntry == null || entry.getValue() > majEntry.getValue()) {
                majEntry = entry;
            }
        }
        
        return majEntry.getKey();
        
    }
}
