class Solution {
    public int uniquePaths(int m, int n) {
        
        int prev[] = new int[n];
        Arrays.fill(prev, 0);
        
        for(int i=0;i<m;i++) {
            int curr[] = new int[n];
            Arrays.fill(curr, 0);
            
            for(int j=0;j<n;j++) {
                
                if(i==0 && j==0)
                    curr[j] = 1;
                else {
                    int up =0;
                    int down = 0;
                    
                    if(i>0)
                        up = prev[j];
                    
                    if(j>0)
                        down = curr[j-1];
                    
                    curr[j] = up+ down;
                }
            }
            prev = curr;
            
        }
        
        return prev[n-1];
        
    }
}