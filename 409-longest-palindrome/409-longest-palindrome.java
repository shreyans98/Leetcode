class Solution {
    public int longestPalindrome(String s) {
        
        if(s.length() ==0)
            return 0;
        if(s.length() ==1)
            return 1;
        int len = 0;
        HashSet<Character> hset = new HashSet<Character>();
        
        for(int i=0;i<s.length();i++) {
            if(!hset.contains(s.charAt(i)))
               hset.add(s.charAt(i));
            else {
                len += 2;
                hset.remove(s.charAt(i));
            }
        }
        
        if(!hset.isEmpty())
            len++;
               
               return len;

        
    }
}