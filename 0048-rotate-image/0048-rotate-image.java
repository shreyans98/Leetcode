class Solution {
    public void rotate(int[][] matrix) {
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        //transpose of a matrix
        for(int i=0;i<row;i++) {
            for(int j=i;j<col;j++) {
                int temp = 0;
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                
            }
        }
        
        for(int i=0;i<row;i++) {
            for(int j=0;j<col/2;j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][row-1-j];
                matrix[i][row-1-j] = temp;
            }
        }
        
    }
}