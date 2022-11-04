class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int len = arr.length;
        int dp[] = new int[len];
        Arrays.fill(dp, -1);
        
        return solve(arr, 0, len, dp, k);
        
    }
    
    public int solve(int arr[], int i, int len, int dp[], int k) {
        if(i == len)
            return 0;
        
        if(dp[i] != -1)
            return dp[i];
        
        int num = 0, mini = Integer.MIN_VALUE;
        int finalAns = Integer.MIN_VALUE;
        
        for(int j=i;j<Math.min(len, i+k);j++) {
            
            num++;
            mini = Math.max(mini, arr[j]);
            int sum = num * mini + solve(arr, j+1, len, dp, k);
            finalAns = Math.max(finalAns, sum);            
        }
        
        return dp[i] = finalAns;
    }
}