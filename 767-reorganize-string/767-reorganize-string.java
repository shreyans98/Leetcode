class Solution {
    public String reorganizeString(String s) {
        
/*
Intuition behind the approach is:

-Calculate the frequency of each character and store it in hash[]
--Find the most occurig character
-Placce the most frequent character in alternate spaces(0,2, 4...)
-Place the rest to the array


*/        
        
        int hash[] = new int[26];
        
        for(int i=0;i<s.length();i++) 
            hash[s.charAt(i)-'a']++;
        
        int max = 0;
        int letter = 0;
        
        //to calculate the most frequent character
        for(int i=0;i<hash.length;i++) {
            if(hash[i]>max) {
                max = hash[i];
                letter = i;
            }
        }
        
        if(max>(s.length()+1)/2)
            return "";
        
        char res[] = new char[s.length()];
                
        int k = 0;
        //to place the most frequent character
        while(hash[letter] > 0) {
            res[k] = (char) (letter + 'a');
            k += 2;
            hash[letter]--;
        }
        
        
        //to place the rest of the character to the array
        for(int j=0;j<hash.length;j++) {
            while(hash[j] > 0) {
                //after placing as many characters as possible in alternate positions keep k as 1 and repeat
                 if(k>=res.length)
                    k=1;
            
               res[k] = (char) (j + 'a');
               k +=2;
               hash[j]--;
            }
            
        }
        
        return String.valueOf(res);
        
        
        
    }
}