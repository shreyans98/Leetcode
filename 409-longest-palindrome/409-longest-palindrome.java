class Solution {
    public int longestPalindrome(String s) {
        
        if(s.length() ==0)
            return 0;
        if(s.length() ==1)
            return 1;
        int len = 0;
        //Hashset to store the frequency of characters
        HashSet<Character> hset = new HashSet<Character>();
        
        for(int i=0;i<s.length();i++) {
            if(!hset.contains(s.charAt(i)))
               hset.add(s.charAt(i));
            else { //if set contains that character then take out that character and increase length by 2 since number of characters will be even now
                len += 2;
                hset.remove(s.charAt(i));
            }
        }
        //if multiple different characters have only 1 occurence or have been used even number of times then we need to increase count by 1 since only once any of them can be used.(length will increase by 1 in all cases)
        if(!hset.isEmpty())
            len++;
               
               return len;

        
    }
}