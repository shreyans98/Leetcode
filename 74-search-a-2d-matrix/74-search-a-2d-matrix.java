class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        //brute force approach
        //Two loops are used to access the individual elements and compare it with the target.
        boolean result=false;
        for(int i=0;i<matrix.length;i++) { // Loop to access individual sub-array
            for(int j=0;j<matrix[0].length;j++) { //loop to access the individual elements
               if(matrix[i][j] == target){
                   result = true;
                   break;
               }
            }
        }
        
        return result;
        
    }
}