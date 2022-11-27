class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> lst = new ArrayList<>();
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length-1;
        
        while(rowBegin <= rowEnd && colBegin <= colEnd) {
            
            //left to right traversal
            for(int i=colBegin;i<=colEnd;i++) {
                lst.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            
            //downwards
            for(int j=rowBegin;j<=rowEnd;j++) {
                lst.add(matrix[j][colEnd]);
            }
            colEnd--;
            
            //leftwards
            if(rowBegin<=rowEnd) {
                for(int k=colEnd;k>=colBegin;k--) {
                    lst.add(matrix[rowEnd][k]);
                }
           
            }
             rowEnd--;
            
            //upwards
            if(colBegin<=colEnd) {
                for(int m=rowEnd;m>=rowBegin;m--) {
                    lst.add(matrix[m][colBegin]);
                } 
            }
            colBegin++;
        }
        
        return lst;
        
    }
}