class Solution {
    public int strStr(String haystack, String needle) {
        
        /*
        Approach behing the problem is:
        We will iterate in the first loop only until haystack.length() - needle.length() since we will not get any substring beyond this position.
        
        Inner loop will help us in checking if each character in both the strings(part of string 1 and whole of string 2) is same or not, if it is not we will not execute the loop anymore and move to next position of the bigger string.
        
        The moment we have the counter of inner loop equal to the length of the needle we know we have found the substring in the bigger string as validation condition was already added in the looping condition. Hence, we will return i as that will be the first occurence.
        
        */
        
        if(needle.length() ==0)
            return 0;
        
        for(int i=0;i<=haystack.length() - needle.length();i++) {
            
            for(int j=0;j<needle.length() && haystack.charAt(i+j) == needle.charAt(j);j++) {
                if(j==needle.length() -1)
                    return i;
            }
        }
        return -1;
    }
}