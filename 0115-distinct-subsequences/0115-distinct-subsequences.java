class Solution {
    public int numDistinct(String s, String t) {
        
        int len1 = s.length();
        int len2 = t.length();
        
        int dp[][] = new int [len1+1][len2+1];
        
        for(int ar[] : dp)
            Arrays.fill(ar, -1);
        
        return solve(len1-1, len2-1, s, t, dp);
        
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