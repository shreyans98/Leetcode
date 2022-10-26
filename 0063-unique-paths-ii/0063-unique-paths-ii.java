class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        
        int dp[][] = new int[row][col];
        
        for(int fill[] : dp)
            Arrays.fill(fill, -1);
        
        return solve(row-1, col-1, obstacleGrid, dp);
        
    }
    
    public int solve(int row, int col, int arr[][], int dp[][]) {
        if(row >= 0 && col >= 0 && arr[row][col] == 1)
            return 0;
        
        if(row ==0 && col ==0)
            return 1;
        
        if(row < 0 || col < 0)
            return 0;
        
        if(dp[row][col] != -1)
            return dp[row][col];
        
        int up = solve(row-1, col, arr, dp);
        int down = solve(row, col-1, arr, dp);
        
        return dp[row][col] = up+down;
    }
}