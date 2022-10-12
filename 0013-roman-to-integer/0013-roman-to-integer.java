class Solution {
    public int romanToInt(String s) {
        
/*
We will start from backwards and if the present character of string is smaller than the previous character(as we are traversing from backwards) then we will subtract the present charcter value. If greater then we will add the value

Ex: IX (first value of X is added to sum, and after that since value of I is smaller than X as we travel backwards
then we have to subtract the value of I)

*/
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int sum = map.get(s.charAt(s.length()-1));
        
        for(int i=s.length()-2;i>=0;i--) {
            char ch = s.charAt(i);
            char ch1 = s.charAt(i+1);
            
            if(map.get(ch)<map.get(ch1))
               sum -= map.get(ch);
            else
                
                sum += map.get(ch);
        }
        
        return sum;
        
    }
}