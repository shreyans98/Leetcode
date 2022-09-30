class Solution {
    public void rotate(int[][] matrix) {
        int tmp = 0;
        transpose(matrix, tmp);
        reverse(matrix, tmp);
        
    }
    
    public void transpose(int[][] t_matrix, int tmp) {
    
        for(int i=0;i<t_matrix.length;i++) {
            for(int j=i+1;j<t_matrix.length;j++) {
                tmp = t_matrix[i][j];
                t_matrix[i][j] = t_matrix[j][i];
                t_matrix[j][i] = tmp;
            }
        }
    }
    
    public void reverse(int[][] r_matrix, int tmp) {
        for(int i=0;i<r_matrix.length;i++) {
            for(int j=0;j<r_matrix.length/2;j++) {
                tmp = r_matrix[i][j];
                r_matrix[i][j] = r_matrix[i][r_matrix.length-j-1];
                r_matrix[i][r_matrix.length-j-1] = tmp;
            }
        }
    }
    
    
}