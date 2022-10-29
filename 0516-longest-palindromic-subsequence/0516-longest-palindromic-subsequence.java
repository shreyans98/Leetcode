class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String rev = sb.toString();
        
        int len = s.length();
        
        int dp[][] = new int[len+1][len+1];
        
        for(int i=0;i<=len;i++)
            dp[i][0] = 0;
        
        for(int j=0;j<=len;j++)
            dp[0][j] = 0;
        
        
        for(int i=1;i<=len;i++) {
            for(int j=1;j<=len;j++) {
                
                char c1 = s.charAt(i-1);
                char c2 = rev.charAt(j-1);
                
                if(c1 == c2)
                    dp[i][j] = 1 + dp[i-1][j-1];
                
                else
                    dp[i][j] = 0 + Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[len][len];
    }
}