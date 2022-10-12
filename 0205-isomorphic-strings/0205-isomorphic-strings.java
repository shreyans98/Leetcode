class Solution {
    public boolean isIsomorphic(String s, String t) {
        

        
        HashMap<Character, Character> map1 = new HashMap<Character, Character>();
        HashMap<Character, Character> map2 = new HashMap<Character, Character>();
        
        for(int i=0;i<s.length();i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            
//we have to see if ch1 has different value in hashmap 1 other than c2 and same for ch2 in case of second hashmap 2
//we have to use containsKey method in order to avoid the key error
            
            if((map1.containsKey(ch1) && map1.get(ch1) != ch2) || (map2.containsKey(ch2) && map2.get(ch2) != ch1))
                return false;
            
            map1.put(ch1, ch2);
            map2.put(ch2, ch1);
        }
        
        return true;
        
    }
}