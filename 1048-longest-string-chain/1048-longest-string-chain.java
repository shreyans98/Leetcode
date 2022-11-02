class Solution {
    public int longestStrChain(String[] words) {
        int len = words.length;
        int dp[] = new int[len];
        int maxi = 0;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        
        
        for(int i=0;i<len;i++) {
            for(int j=0;j<i;j++) {
                
                if(compare(words[i], words[j]) && 1 + dp[j]>dp[i]) 
                    dp[i] = 1 + dp[j];
                
                
            }
            maxi =  Math.max(maxi, dp[i]);
        }
        
        return maxi+1;
        
    }
    
    public boolean compare(String str1, String str2) {
        if(str1.length() != str2.length() + 1)
            return false;
        
        int first = 0;
        int second = 0;
        
        while(first < str1.length()) {
            
            if(second < str2.length() && str1.charAt(first) == str2.charAt(second)){
                first++;
                second++;
            }
            
            else
                first++;
        }
        
        if(first == str1.length() && second == str2.length())
            return true;
        return false;
    }
}