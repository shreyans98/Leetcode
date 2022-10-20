class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int total = 0, sum=0;
        //we will take the sum from strting as we have to choose either the first and last element
        for(int i=0;i<k;i++)
            sum += cardPoints[i];
        total = sum;
        
        //Now we will start removing element from the back (kth position) and start adding element from last position since the only choice of starting is either from 0th index or last index and calculate the sum in each cycle to calculate max length
        for(int i=k-1, j = cardPoints.length-1; i >=0;i--,j--) {
            sum += cardPoints[j] - cardPoints[i];
            
            total = Math.max(total, sum);
            
        }
        
        return total;
        
        
    }
}