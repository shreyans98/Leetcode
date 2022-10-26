class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int dp[][] = new int[row][col];
        
        for(int arr[] : dp)
            Arrays.fill(arr, -1);
        
        int maxi = Integer.MAX_VALUE;
        
        for(int i=0;i<col;i++) {
            maxi = Math.min(maxi, solve(row-1, i, matrix, dp));
            
        }
        
        return maxi;
        
    }
    
    public int solve(int row, int col, int matrix[][], int dp[][]) {
        
        if(col < 0 || col >= matrix[0].length)
            return (int) Math.pow(10, 9);
        
        if(row ==0)
            return matrix[row][col];
        
        if(dp[row][col] != -1)
            return dp[row][col];
        
        else {
            int up = matrix[row][col] + solve(row-1, col, matrix, dp);
            int rgDia = matrix[row][col] + solve(row-1, col+1, matrix, dp);
            int lefDia = matrix[row][col] + solve(row-1, col-1, matrix, dp);
            
            
            return dp[row][col] = Math.min(up, Math.min(lefDia, rgDia));
        }
        
        
    }
}