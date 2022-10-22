class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
         //base cndition as we will not be able to divide into groupsize with groupsize number of elements
        if(hand.length % groupSize !=0)
            return false;
        
        
        //Tree map helps us to store the value pair in sorted order
        TreeMap<Integer, Integer> tmap = new TreeMap<Integer, Integer>();
        
        //dump everything into treemap with frequency
        for(int card : hand){
            if(!tmap.containsKey(card))
                tmap.put(card, 1);
            else
                tmap.replace(card, tmap.get(card) + 1);
        }
        
        
        //loop for validation
        while(tmap.size() > 0) {
            int min_val = tmap.firstKey(); //we get the minimum value
            
            //loop validation to check if we have consecutive values or not
            for(int card=min_val;card<min_val+groupSize;card++) {
                if(!tmap.containsKey(card)) //if no consecutive values then return false
                    return false;
                
                int count = tmap.get(card);
                if(count ==1) //remove the card 
                    tmap.remove(card);
                else
                    tmap.replace(card, count - 1); //decrease the value of card
                
            }
        }
        
        return true;
        
    }
}