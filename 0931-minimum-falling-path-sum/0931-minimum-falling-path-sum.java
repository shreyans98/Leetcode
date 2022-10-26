class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int dp[][] = new int[row][col];
        
        
        int maxi = Integer.MAX_VALUE;
        
        for(int j=0;j<col;j++)
            dp[0][j] = matrix[0][j];
        
        for(int i=1;i<row;i++) {
            for(int j=0;j<col;j++) {
                
                int up = matrix[i][j] + dp[i-1][j];
                int leftDia = matrix[i][j];
                int rightDia = matrix[i][j];
                
                if(j>0)
                    leftDia += dp[i-1][j-1];
                else
                    leftDia += (int) Math.pow(10, 9);
                
                if(j<col-1)
                    rightDia += dp[i-1][j+1];
                else
                    rightDia += (int) Math.pow(10, 9);
                
                dp[i][j] = Math.min(up, Math.min(leftDia, rightDia));
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i=0;i<col;i++)
            result = Math.min(result, dp[row-1][i]);
        
        return result;
    }
}