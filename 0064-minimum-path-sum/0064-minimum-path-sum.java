class Solution {
    public int minPathSum(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        
        int dp[][] = new int[row][col];
        
        for(int x[]: dp)
            Arrays.fill(x, -1);
        
        return solve(row-1, col-1, grid, dp);
        
    }
    
    public int solve(int row, int col, int grid[][], int dp[][]) {
        
        if(row ==0 && col ==0)
            return grid[row][col];
        
        if(row<0 || col < 0)
            return (int)Math.pow(10,9);
        
        if(dp[row][col] != -1)
            return dp[row][col];
        
        int up = solve(row-1, col, grid, dp) + grid[row][col];
        
        int left = solve(row, col-1, grid, dp) + grid[row][col];
        
        return dp[row][col] =  Math.min(up, left);
        
    }
}