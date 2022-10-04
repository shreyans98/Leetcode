class Solution {
    public boolean lemonadeChange(int[] bills) {
        
        //brute force approach
        
        if(bills[0] != 5)
            return false;
        
        int five = 0;
        int ten = 0;
        
        for(int i=0;i<bills.length;i++) {
            
            if(bills[i] ==5)
                five++;
            
            else if(bills[i] ==10) {
                five--;
                ten++;
            }
            //for 20$ bill we will check if we have 10$ bill or not, if we do not have it then we have to pay 3 5$
            else {
                if(ten >0 && five >=1) {
                    ten--;
                    five--;
                }
                else
                    five -= 3;
            }
            //if at any point we have 0 5$ then condition breaks
            if(five<0)
                return false;
            
        }
        
        return true;
    }
}