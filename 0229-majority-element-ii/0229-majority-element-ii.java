class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums) 
            map.put(num, map.getOrDefault(num, 0)+1);
        
        
        for(int x : map.keySet())
            if(map.get(x) > (len/3))
                res.add(x);
        
        return res;
        
        
    }
}