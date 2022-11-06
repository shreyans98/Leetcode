class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        int rowCount[] = new int[row];
        int colCount[] = new int[col];
        
        Arrays.fill(rowCount, -1);
        Arrays.fill(colCount, -1);
        
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                
                if(matrix[i][j] ==0){
                    rowCount[i] = 0;
                    colCount[j] = 0;
                }
            }
        }
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++) {
                if(rowCount[i] ==0 || colCount[j] == 0)
                    matrix[i][j] = 0;
            }
        }
        
    }
}