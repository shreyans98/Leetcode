class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() ==0)
            return 0;
        
        int len = Integer.MIN_VALUE;
        
        Set<Character> set = new HashSet<>();
        
        int left = 0;
        
        for(int right=0;right<s.length();right++) {
            
            if(set.contains(s.charAt(right))) {
                
                while(left<right && set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                }   
            }
            set.add(s.charAt(right));
            len = Math.max(len, right-left+1);
        }
        
        return len;
        
    }
}