class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int len = triangle.size();
        int dp[][] = new int[len][len+1];
        
        
        for(int i=len-1;i>=0;i--) {
            for(int j=0;j<triangle.get(i).size();j++) {
                
                if(i == len-1)
                    dp[i][j] = triangle.get(i).get(j);
                
                else {
                    int down = triangle.get(i).get(j) + dp[i+1][j];
                    int diagonal = triangle.get(i).get(j) + dp[i+1][j+1];
                    
                    dp[i][j] = Math.min(down, diagonal);
                }
            }
        }
        
        return dp[0][0];
        
    }
}