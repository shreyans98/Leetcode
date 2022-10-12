class Solution {
    public String frequencySort(String s) {
        
        HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
        
        for(char ch: s.toCharArray()) //hashmap to store the frequency, every charcter is stored in form of key with value as frequency
            hmap.put(ch, hmap.getOrDefault(ch, 0)+1);
        
        List<Character> lst = new ArrayList<>(hmap.keySet()); //since we cannot sort in hashmap, hence we use list to sort the character according to frequency
        lst.sort((x, y) -> hmap.get(y) - hmap.get(x)); //to sort in descending order
        
        //to sort in ascending order use
        //lst.sort((x,y) -> hmap.get(x) - hmap.get(y));
        
        StringBuilder sb = new StringBuilder();
        
        for(char ch1: lst){
            for(int j=0;j<hmap.get(ch1);j++)//using frequency to build the string
                sb.append(ch1);
        }
        
        return sb.toString();
    }
}