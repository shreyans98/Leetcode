class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        
        int dp[][] = new int[len1+1][len2+1];
        
        
        
        for(int ar[] : dp)
            Arrays.fill(ar, -1);
        
        return solve(text1, text2, len1, len2, dp);
        
    }
    
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