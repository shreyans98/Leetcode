class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        
        /*
Intuition behind the approach is we will take all the possibilities within  the limit of piles[i] range, that is
low will be 1(minimum 1 banana to eat)
high wil be 10^9 (max banana in 1 pile)

Now we can use binary search to check for the middle element, if it takes time less than or more than h already given. If the time taken is more then we will shift high to mid-1 since there is a possibility that we can eat further eat less bananas in a given time. 

Similarly if the hours taken is more, it means we have to eat more bananas and hence we will shift low = mid+1. 


There is also a possibility that eating more bananas will reduce time, but we have to minimise this and hence by binary search we can get to a point where we can utilise all the hours by eating minimum bananas

*/
        
        
        int low = 1, high = 1000000000, k = 0;
        while (low <= high) {
            k = (low + high) / 2;
            int h = 0;
            for (int i = 0; i < piles.length; i ++) 
                h += Math.ceil(1.0 * piles[i] / k);
            if (h > H)
                low = k + 1;
            else
                high = k - 1;
        }
        return low;
    }
}