class Solution {
    public int minDistance(String word1, String word2) {
        
        int len1 = word1.length();
        int len2 = word2.length();
        
        int prev[] = new int[len2+1];
        int curr[] = new int[len2+1];
        
        
        for(int j=0;j<=len2;j++)
            prev[j] = j;
            
        
        for(int i=1;i<=len1;i++) {
            curr[0] = i;
            for(int j=1;j<=len2;j++) {
                
                char c1 = word1.charAt(i-1);
                char c2 = word2.charAt(j-1);
                
                if(c1 == c2)
                    curr[j] = 0 + prev[j-1];
                
                else
                    curr[j] = Math.min(1 + curr[j-1], Math.min((1 + prev[j]), (1 + prev[j-1]))); 
            }
            prev = (int[])(curr.clone());
        }
        
        return prev[len2];
        
    }
}





/*Memoization Solution

---------------------------------------------------------------------------------------------------------------------------------



class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        
        int dp[][] = new int[len1+1][len2+1];
        for(int ar[]: dp)
            Arrays.fill(ar, -1);
        
        return solve(len1-1, len2-1, word1, word2, dp);
        
    }
    
    public int solve(int ind1, int ind2, String s1, String s2, int dp[][]) {
        //base case
        
        if(ind1<0)
            return ind2+1;
        
        if(ind2<0)
            return ind1+1;
        
        
        if(dp[ind1][ind2] != -1)
            return dp[ind1][ind2];
        
        
        
        if(s1.charAt(ind1) == s2.charAt(ind2))
            return dp[ind1][ind2] = 0 + solve(ind1-1, ind2-1, s1, s2, dp);
        
        else {
            return 
                dp[ind1][ind2] = Math.min((1 + solve(ind1, ind2-1, s1, s2, dp)), Math.min((1 + solve(ind1-1, ind2, s1, s2, dp)),
                                                                                     (1 + solve(ind1-1, ind2-1, s1, s2, dp))));
        }
        
    }
}



/////////////////////////////////////////////////////////
Tabulation Solution


*/