class Solution {
    public int minDistance(String word1, String word2) {
        
        int len1 = word1.length();
        int len2 = word2.length();
        
        int prev[] = new int[len2+1];
        int curr[] = new int[len2+1];
        
        for(int i=1;i<=len1;i++) {
            for(int j=1;j<=len2;j++) {
                
                char c1 = word1.charAt(i-1);
                char c2 = word2.charAt(j-1);
                
                if(c1 == c2)
                    curr[j] = 1 + prev[j-1];
                
                else
                    curr[j] = 0 + Math.max(prev[j], curr[j-1]);
            }
            
            prev = (int[])(curr.clone());
        }
        
        return (len1+len2) - (2 * prev[len2]);
        
    }
}