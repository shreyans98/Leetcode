class Solution {
    public int findMinFibonacciNumbers(int k) {
     
//Find the range in fibonacci series in which the k lies 
//f1 is lower limit, f2 is upper limit
        int f1 = 1;
        int f2 = 1;
        int count = 0;
        while(f2<=k) {
            int fn = f1+f2;
            f1 = f2;
            f2 = fn;
        }
//best case scneraio is when number itself is present in series, hence count will be 1        
        count = 1;
        k -= f1;
        
        while (k>0) {
  //find new range of k in fibonacci series          
            while(f1>k) {
                int ff = f2-f1;
                f2 = f1;
                f1 = ff;
            }
             k -= f1;
            count++;
        }
        
        return count;
        
    }
}