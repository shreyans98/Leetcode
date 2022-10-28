class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        
        int prev[] = new int[len2+1];
        int curr[] = new int[len2+1];
        
        
        
        
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                
                char c1 = text1.charAt(i-1);
                char c2 = text2.charAt(j-1);
                
                if(c1 == c2)
                    curr[j] = 1 + prev[j-1];
                else
                    curr[j] = 0 + Math.max(curr[j-1], prev[j]);
            }
            prev=(int[])(curr.clone());
        }
        
        return prev[len2];
        
    }
    
    
     public int longestCommonSubsequenceT(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        
        int dp[][] = new int[len1+1][len2+1];
        
        for(int i=0;i<len1;i++)
            dp[i][0] = 0;
        
        for(int j=0;j<len2;j++)
            dp[0][j] = 0;
        
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                
                char c1 = text1.charAt(i-1);
                char c2 = text2.charAt(j-1);
                
                if(c1 == c2)
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = 0 + Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        
        return dp[len1][len2];
        
    }
    
    
    //not used
    public int solve(String s1, String s2, int ind1, int ind2, int dp[][]) {
        
        //base case
        if(ind1 == 0 || ind2 == 0)
            return 0;
        
        if(dp[ind1][ind2] != -1)
            return dp[ind1][ind2];
        
        
        char c1 = s1.charAt(ind1-1);
        char c2 = s2.charAt(ind2-1);
        
        if(c1 == c2)
            return dp[ind1][ind2] = 1 + solve(s1, s2, ind1-1, ind2-1, dp);
        
        else
            return dp[ind1][ind2] =  0 + Math.max(solve(s1, s2, ind1-1, ind2, dp), solve(s1, s2, ind1, ind2-1, dp));
        
    }
}