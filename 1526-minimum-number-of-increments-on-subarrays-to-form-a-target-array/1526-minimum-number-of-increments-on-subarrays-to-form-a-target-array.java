class Solution {
    public int minNumberOperations(int[] target) {
        
/*
Intuition behind the approach is that the least number of moves that we will do to achieve the target is equal to the value at the 0th index (irrespective of whether it is highest or lowest)

Now for the values which are less than the value at 0th index, the target has already been achieved in the moves prior to the one in which the target for 0th index is reached(possibility is that after the target is achieved for smaller values we will not increament it, but will only increament for 0th index since it is greater.)



Now for the values which are higher than 0th index value, we need those many extra moves to achieve target for that, hence we are looking for next greater value, and substracting that value with the previous value we will get the other additional moves. Hence that will be minimum moves since value smaller than that will already be covered.

Same approach to be used continuously till the end of array.
*/
        
        int moves = target[0];
        
        for(int i=1;i<target.length;i++) {
            if(target[i] > target[i-1])
                moves += target[i] - target[i-1];
        }
        
        return moves;
        
    }
}