class Solution {
    public int minInsertions(String s) {
        int len = s.length();
        
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String rev = sb.toString();
        
        int dp[][] = new int[len+1][len+1];
        
        for(int i=0;i<=len;i++){
            dp[0][i] = 0;
            dp[i][0] = 0;
        }
        
        for(int i=1;i<=len;i++) {
            for(int j=1;j<=len;j++) {
                
                char c1 = s.charAt(i-1);
                char c2 = rev.charAt(j-1);
                
                if(c1==c2)
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = 0 + Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        
        return len - dp[len][len];
        
    }
}