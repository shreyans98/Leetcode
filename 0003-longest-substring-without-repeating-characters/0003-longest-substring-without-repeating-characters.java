class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character, Integer> hmap = new HashMap<>();
        
        
        int left = 0, right = 0;
        int len = 0;
        int n = s.length();
        
        
        while(right < n) {
            char ch = s.charAt(right);
            if(hmap.containsKey(ch))
                left = Math.max(hmap.get(ch)+1, left);
            
            hmap.put(ch, right);
            len = Math.max(len, right-left+1);
            right++;
            
        }
        
        return len;
        
    }
}