class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int prev[] = new int[col];
        
        
        int maxi = Integer.MAX_VALUE;
        
        for(int j=0;j<col;j++)
            prev[j] = matrix[0][j];
        
        for(int i=1;i<row;i++) {
            int curr[] = new int[col];
            for(int j=0;j<col;j++) {
                
                int up = matrix[i][j] + prev[j];
                int leftDia = matrix[i][j];
                int rightDia = matrix[i][j];
                
                if(j>0)
                    leftDia += prev[j-1];
                else
                    leftDia += (int) Math.pow(10, 9);
                
                if(j<col-1)
                    rightDia += prev[j+1];
                else
                    rightDia += (int) Math.pow(10, 9);
                
                curr[j] = Math.min(up, Math.min(leftDia, rightDia));
            }
            prev = curr;
        }
        int result = Integer.MAX_VALUE;
        for(int i=0;i<col;i++)
            result = Math.min(result, prev[i]);
        
        return result;
    }
}