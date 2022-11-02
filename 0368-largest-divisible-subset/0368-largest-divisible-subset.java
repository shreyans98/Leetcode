class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        int dp[] = new int[len];
        int hash[] = new int[len];
        
        Arrays.sort(nums);
        
        Arrays.fill(dp, 1);
        
        for(int i=0;i<=len-1;i++) {
            hash[i] = i;
            for(int j=0;j<i;j++) {
                
                if(nums[i] % nums[j] ==0 && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
        }
        
        int ans = -1;
        int lastIndex = -1;
        
        for(int i=0;i<len;i++) {
            if(dp[i] > ans){
                ans = dp[i];
                lastIndex = i;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        res.add(nums[lastIndex]);
        
        while(hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            res.add(nums[lastIndex]);
        }
        
        return res;
        
    }
}