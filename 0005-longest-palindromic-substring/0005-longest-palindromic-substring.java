class Solution {
    public String longestPalindrome(String s) {
        
        /*
        We will use the expand around center approach. We know that palindrome mirror arounds the center so we will expand both the boundaries as much as possible. When the length is odd then we will have single character as the middle but when it is even then we will have double character as the middle.
        
        We calculate the len1 if it is odd character string and len2 if it is even character string and expand in that way.
        
        Helper function helps us in increasiing our boundary to the maximum extent possible.
        
        
        */
        if(s== null || s.length() < 1)
            return "";
        
        
        int start = 0;
        int end = 0;
        
        for(int i=0;i<s.length();i++) {
            int len1 = help(s, i, i);
            int len2 = help(s, i, i+1);
            int len = Math.max(len1, len2);
            
            System.out.println("len1"+len1);
            System.out.println("len2"+len2);

            System.out.println("len"+len);
            if(len > end - start) {
                start = i - ((len-1)/2);
                end = i + (len/2);
                System.out.println("start"+start);
                System.out.println("end"+end);
            }
        }
        
        return s.substring(start, end+1);
        
    }
    
    public int help(String st, int left, int right) {
        if(st == null || left > right)
            return 0;
        
        while(left>=0 && right < st.length() && st.charAt(left) == st.charAt(right)) {
            left--;
            right++;
        }
        
        return right-left-1;
    }
}