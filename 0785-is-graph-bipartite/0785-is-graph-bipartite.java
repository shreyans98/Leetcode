class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        
        int color[] = new int[n];
        
        for(int i=0;i<n;i++)
            if(color[i] ==0 && !valid(graph, color, 1, i))
                return false;
        
        return true;
        
    }
    
    public boolean valid(int graph[][], int color[], int col, int node) {
        if(color[node] != 0)
            return color[node] == col;
        
        color[node] = col;
        
        for(int next : graph[node]) {
            if(!valid(graph, color, -col, next))
                return false;
        }
        return true;
    }
}