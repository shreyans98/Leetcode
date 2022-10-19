class Solution {
    public int characterReplacement(String s, int k) {
        
        int len = s.length();
        int start = 0, max_length = 0, max_count = 0;
        //to store the frequency of each character
        int char_count[] = new int[26];
        
        for(int end = 0;end<len;end++){//string traversal
            char_count[s.charAt(end) - 'A']++;
            int current_char_count = char_count[s.charAt(end) - 'A'];
            max_count = Math.max(max_count, current_char_count);//max repeating character length-> since it will be this character which we will use to replace the other character k times so that we can get our maximum substring length
            
/*

->end-start is the window 
->max_count is the maximum repeating character
->(end-start-max_count) is the non repeating character present in that window
We are adding 1 as we will be adding 1 in each loop a
and all of this should be less than k
 and if they are greater than we will remove elements from the starting of the window.

*/
            while(end-start-max_count+1 >k){
                char_count[s.charAt(start) - 'A']--;
                start++;
            }
             max_length = Math.max(max_length, end-start+1);
            
        }
        
        return max_length;
        
    }
}