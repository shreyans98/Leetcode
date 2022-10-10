class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int arr1 = 0; //to access the outer array
        int arr2 = m-1; //to access the inner array
        
        
        while(arr1 < n && arr2 >= 0) {
            if(matrix[arr1][arr2] == target)
                return true;
            else if(matrix[arr1][arr2] > target) 
                arr2--;
                  
            else if(matrix[arr1][arr2] < target)
                arr1++;
        }
        
        return false;
        
    }
}