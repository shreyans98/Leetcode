class Solution {
    public List<String> letterCombinations(String digits) {
        
        LinkedList<String> list = new LinkedList<String>();
        if(digits.length() == 0)
            return list;
        
        list.add("");
        
        String[] char_map = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        for(int i=0;i<digits.length();i++) {
            //gets the value of each character in order to fetch the character mapping of that number
            int index = Character.getNumericValue(digits.charAt(i));
            
            //to maintain the number of digits in the list which is to be same as number of individual digits of input
            while(list.peek().length() == i) {
                
                //to pop up each character for combining with the next character of the second digits(ex: we pop a first to form ->a + d, a + e)
                String permutation = list.remove();
                //loop to take each character from the group of characters assigned to a digits
                for(char c: char_map[index].toCharArray())
                    list.add(permutation + c);
            }
            
        }
        
        return list;
        
        
        
    }
}