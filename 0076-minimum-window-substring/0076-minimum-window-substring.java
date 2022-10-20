class Solution {
    public String minWindow(String s, String t) {
        
          int sourceStrLen = s.length();
        int subStrLen = t.length();
        int end = 0, start=0, minLen = Integer.MAX_VALUE;
        
        int counter = t.length();
        int minStart = 0;
         
        if(sourceStrLen==0 || subStrLen==0 || sourceStrLen < subStrLen)
            return "";
        
        
        
        int freq[] = new int[128];
        //to store the frequency of characters present in target substring
        for(int i=0;i<t.length();i++)
            freq[t.charAt(i)]++;
        
      //sliding window approach to find if t is a substring of s or not
        while(end<sourceStrLen) {
            if(freq[s.charAt(end)]>0) //character is present in source string, hence our counter will reduce
                counter--;
            freq[s.charAt(end)]--;
            end++;

/*

WHen counter becomes 0 that means t is a substring of s

when we have found all the character of substring in main string, then only we have to find the min length after this since we contain the substring in the main string
           
*/
 
            
            while(counter ==0) {
                if(minLen > end-start){//if we get the min length, then we can say that we have got the start where we will get the minimum length of the string
                    minLen = end-start;
                    minStart = start;
                }
                //we will update the counter if we contain that string in pur frequency array
                freq[s.charAt(start)]++;
                if(freq[s.charAt(start)]>0)
                    counter++;
                start++;

            }
                
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart+minLen);
        
    }
    
    
}