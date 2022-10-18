class Solution {
    public int longestOnes(int[] nums, int k) {
        
/*
Intuition behind the solution

We will use sliding window approach

first will be the initial pointer, last will be the pointer that traverses the array

 keep on incrementing last till the end of the array



*/
        int first = 0;
        int last = 0;
        
        while(last< nums.length) {
            //reduce k when we encounter 0 in order check for length
            if(nums[last]==0)
                k--;
            //if k becomes 0 that means we have reached our limit so now we will start moving our initial pointer
            if(k<0){  
                //if initial pointer encounters 0 that means we will be omitting zeroes in our approach between first & last and hence we have to increase the value of K
                if(nums[first] ==0)
                    k++;
                first++;
            }
            
            last++;
        }
        
        return last-first;
        
    }
}