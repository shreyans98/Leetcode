class Solution {
    public int numDistinct(String s, String t) {
        
        int len1 = s.length();
        int len2 = t.length();
        
        int dp[][] = new int [len1+1][len2+1];
        
        //1 based indexing with indexes shifted by +1
        
        //string2 is exhausted so we will return 1 from here
        for(int i=0;i<=len1;i++)
            dp[i][0] = 1;
        
        for(int j=1;j<=len2;j++)
            dp[0][j] = 0;
        
        for(int i=1;i<=len1;i++) {
            for(int j=1;j<=len2;j++) {
                
                char c1 = s.charAt(i-1);
                char c2 = t.charAt(j-1);
                
                if(c1 == c2)
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        
        return dp[len1][len2];
        
        
        
//         for(int ar[] : dp)
//             Arrays.fill(ar, -1);
        
//         return solve(len1-1, len2-1, s, t, dp);
        
    }
    
    public int solve(int ind1, int ind2, String s1, String s2, int dp[][]) {
        //base case
        //string 2 exhausted(no more strings to be matched)
        if(ind2<0)
            return 1;
        
        if(ind1 < 0)
            return 0;
        
        if(dp[ind1][ind2] != -1)
            return dp[ind1][ind2];
        
        int match = 0;
        int notMatch = 0;
        
        if(s1.charAt(ind1) == s2.charAt(ind2))
            match = solve(ind1-1, ind2-1, s1, s2, dp) + solve(ind1-1, ind2, s1, s2, dp);
        
        else
            notMatch = solve(ind1-1, ind2, s1, s2, dp);
        
        return dp[ind1][ind2] = match+notMatch;
    }
    
}