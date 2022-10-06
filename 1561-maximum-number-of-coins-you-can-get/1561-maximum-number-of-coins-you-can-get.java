class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        
        int rp = piles.length-1;
        int mp = rp-1;
        int lp = 0;
        int sum = 0;
        if(piles.length ==3)
            return piles[mp];
        
        while(mp>lp) {
            sum += piles[mp];
            rp = mp-1;
            mp = rp-1;
            lp++;
        }
        
        return sum;
    }
}