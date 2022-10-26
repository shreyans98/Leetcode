class Solution {
    public int minPathSum(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        
        int prev[] = new int[col];
        
        
        for(int i=0;i<row;i++) {
            int curr[] = new int[col];
            for(int j=0;j<col;j++) {
                
                if(i==0 && j==0) {
                    curr[j] = grid[i][j];
                    continue;
                }
                
                else {
                    int up = grid[i][j];
                    int left = grid[i][j];
                    
                    if(i>0)
                        up += prev[j];
                    else
                        up += (int) Math.pow(10, 9);
                    
                    if(j>0)
                        left += curr[j-1];
                    else
                        left += (int) Math.pow(10, 9);
                    
                    curr[j] = Math.min(up, left);
                        
                }
            }
            
            prev = curr;
        }
        
        return prev[col-1];
        
    }
}