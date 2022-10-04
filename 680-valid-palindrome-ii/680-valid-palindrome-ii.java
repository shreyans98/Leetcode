class Solution {
    public boolean validPalindrome(String s) {
        
//2 pointer approach        
        int len = s.length();
        int leftIndex = 0;
        int rightIndex = len-1;
        
        while(leftIndex < rightIndex) {
            if(s.charAt(leftIndex) != s.charAt(rightIndex)) //when first character is not same we check for another character either on left side or right side
                return checkPalindrome(leftIndex+1, rightIndex, s) || checkPalindrome(leftIndex, rightIndex-1,s);
            leftIndex++;
            rightIndex--;
        }
        
        return true;
        
    }
    
    public boolean checkPalindrome(int i, int j, String s) {
        while(i<j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}

//"eeccccbebaeeabebccceea"