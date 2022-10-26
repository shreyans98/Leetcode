class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int len = triangle.size();
        int dp[][] = new int[len][len];
        
        for(int row[] : dp)
            Arrays.fill(row, -1);
        
        return solve(triangle, 0, 0, len, dp);
        
    }
    
    public int solve(List<List<Integer>> triangle, int i, int j, int len, int dp[][]) {
        if(i == len-1)
            return triangle.get(i).get(j);
        
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        
        int down = triangle.get(i).get(j) + solve(triangle, i+1, j, len, dp);
        int diagonal = triangle.get(i).get(j) + solve(triangle, i+1, j+1, len, dp);
        
        
        return dp[i][j] = Math.min(down, diagonal);
    }
}