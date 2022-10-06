class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        
        int rp = piles.length-1; //right pointer for maximum allocation
        int mp = rp-1; //middle pointer for second maximum allocation
        int lp = 0; //left pointer for minimum allocation
        int sum = 0;
       
        
        while(mp>lp) {
            sum += piles[mp];
            rp = mp-1;
            mp = rp-1;
            lp++;
        }
        
        return sum;
    }
}