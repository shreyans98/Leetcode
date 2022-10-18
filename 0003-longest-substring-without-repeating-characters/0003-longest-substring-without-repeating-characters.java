class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> set = new HashSet<Character>();
        int max = 0;
        
        int len = s.length();
        if(len ==0)
            return 0;
        
        if(len ==1)
            return 1;
        
        int left = 0, right = 0;
        
        while(right < len){
            if(!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                max = Math.max(max, set.size());
            }
            
            else
                set.remove(s.charAt(left++));
        }
        return max;
        
    }
}