class Solution {
    public int numberOfSubstrings(String s) {
        
        int count[] = {0,0,0};
        int res = 0, start = 0;
        
        for(int end=0;end<s.length(); end++) {
            count[s.charAt(end) - 'a']++;
            
            while(count[0] > 0 && count[1] > 0 && count[2] > 0)
                count[s.charAt(start++)-'a']--;
            
            res += start;
        }
        
        return res;
        
    }
    
    
}