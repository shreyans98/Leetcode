class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int iniColor = image[sr][sc];
        int ans[][] = image;
        
        int delRow[] = {-1, 0, +1, 0};
        int delCol[] = {0, +1, 0, -1};
        
        dfs(sr, sc, ans, image, color, delRow, delCol, iniColor);
        return ans;
        
    }
    
    public void dfs(int row, int col, int ans[][], int image[][], int newColor, int delRow[], int delCol[], int iniColor) {
        ans[row][col] = newColor;
        int n = ans.length;
        int m = ans[0].length;
        
        for(int i=0;i<4;i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            
            if(nrow>=0 && nrow < n && ncol >= 0 && ncol < m && ans[nrow][ncol] == iniColor && ans[nrow][ncol] != newColor) 
                dfs(nrow, ncol, ans, image, newColor, delRow, delCol, iniColor);
        }
    }
}