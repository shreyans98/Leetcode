//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        
        int color[] = new int[n];
        if(graphColoringUtil(graph, m, color, 0, n) == false){
            return false;
        }
        return true;
    }
    
    public boolean graphColoringUtil(boolean graph[][], int m, int color[], int index, int v) {
        //if all vertices are assigned color then we will return true
        if(index == v) return true;
        
        for(int c=1;c<=m;c++) {
            //checking if this color can be assigned to the graph
            if(isSafe(index, graph, color, c, v)){
                color[index] = c;
                
             //calling the method recursively to check if others can be assigned to different colors
             
             if(graphColoringUtil(graph, m, color, index+1, v) == true){
                 return true;
             }
             //if not possible then we backtrack and change the assigned color to 0
             color[index] = 0;
            }
        }
        //if no color can be assigned then we return false
        return false;
    }
    
    public boolean isSafe(int index, boolean graph[][], int color[], int c, int v){
        
        for(int i=0;i<v;i++) {
            if(graph[index][i] && c == color[i]) {
                return false;
            }
        }
        return true;
    }
}