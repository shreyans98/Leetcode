class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        
        Arrays.sort(satisfaction);
        
        int len = satisfaction.length;
        int p1 = len;
        int lp = 0;
        int p = len-1;
        int temp = 0;
        int sum = 0;
        int elements = len-1;
        int ratio = 0;
        int i = 1;
        
        
        
        while(lp < len) {
            
            while(elements >= 0) {
                temp = p1 * satisfaction[p];
                sum += temp;
                p--;
                p1--;
                elements--;
            }
            
            p = len -1;
            ratio = Math.max(ratio, sum);
            sum = 0;
            lp++;
            p1 = len - i;
            elements = p1;
            i++;
        }
        
        return ratio;
        
    }
}