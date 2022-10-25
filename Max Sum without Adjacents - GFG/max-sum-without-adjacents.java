//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
        // code here
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return find(n-1, arr, dp);
    }
    
    int find(int n, int arr[], int dp[]) {
        
        if(n ==0)
        return arr[n];
        
        if(n ==-1)
        return 0;
        
        if(dp[n] != -1)
        return dp[n];
        
        int pick = arr[n] + find(n-2, arr, dp);
        int notPick = 0 + find(n-1, arr,dp);
        
        return dp[n] = Math.max(pick, notPick);
    }
}