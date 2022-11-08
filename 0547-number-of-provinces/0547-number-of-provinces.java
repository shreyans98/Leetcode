class Solution {
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        boolean vis[] = new boolean[len];
        
        int count = 0;
        
        for(int i=0;i<len;i++) {
            if(!vis[i]) {
                count++;
                dfs(isConnected, i, vis);
            }
        }
        
        return count;
        
    }
    
    
    public void dfs(int arr[][], int i, boolean vis[]) {
        for(int j=0;j<arr.length;j++) {
            if(!vis[j] && arr[i][j]!=0){
                vis[j] = true;
                dfs(arr, j, vis);
            }
        }
    }
}