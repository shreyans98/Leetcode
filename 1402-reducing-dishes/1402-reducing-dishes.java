class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        
        Arrays.sort(satisfaction);
        
        int len = satisfaction.length;
        int p1 = len;
        int p = len-1; //variable to access each character
        int temp = 0;
        int sum = 0;
        int elements = len-1; //number of elements for maximum ratio
        int ratio = 0;
        int i = 1;
        
        
        
        while(elements>=0) { //we will start with maximum elements and reduce it accordingly
            
            while(elements >= 0) { //loop to calculate the sum 
                temp = p1 * satisfaction[p];
                sum += temp;
                p--; //index of each array element
                p1--; 
                elements--;
            }
            
            p = len -1; //restore p to access the last positive element again
            ratio = Math.max(ratio, sum);
            sum = 0; //sum made 0 for next pass
            p1 = len - i; //reducing the element in every pass
            elements = p1;
            i++; //decreasing the elements for sum
        }
        
        return ratio;
        
    }
}