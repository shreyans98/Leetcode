class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        
        //find the sum to check if it has an average over 3 parts
        int sum = 0;
        for(int i: arr){
            sum += i;
        }
        
        if(sum %3 !=0)
            return false;
        
        
        int count = 0;
        int part = 0;
        for(int k: arr) {
             part += k; //calculate the sum of parts
            
            if(part == sum/3) {
                part = 0; //part sum now back to 0 for next phase of calculation
                count++;
                
                if(count ==3)
                    return true;
            }
        }
        
        return false;
        
    }
}