class Solution {
    public int minCut(String s) {
        int len = s.length();
        
        int dp[] = new int[len+1];
        
        for(int i=len-1;i>=0;i--) {
            int minCost = Integer.MAX_VALUE;
            
            for(int j=i;j<len;j++) {
                if(isPalindrome(s, i, j)){
                    int cost = 1 + dp[j+1];
                    minCost = Math.min(minCost, cost);
                }
            }
            dp[i] = minCost;
        }
        
        return dp[0]-1;
        
        
       // Arrays.fill(dp, -1);
        
       // return solve(s, 0, len, dp);
    }
    
    public int solve(String s, int i, int len, int dp[]) {
        if(i == len || isPalindrome(s, i, len-1))
            return 0;
        
        if(dp[i] != -1)
            return dp[i];
            
        int minCost = Integer.MAX_VALUE;
        for(int j =i;j<len;j++) {
            if(isPalindrome(s, i, j)) {
                int cost = 1 + solve(s, j+1, len, dp);
                minCost = Math.min(minCost, cost);
            }
        }
        return dp[i] = minCost;
        
    }
    
    public boolean isPalindrome(String s, int i, int j) {
        while(i<=j) {
            if(s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}