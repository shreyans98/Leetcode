class Solution {
    public int beautySum(String s) {
        
        int sum = 0;
        
        for(int i=0;i<s.length();i++) {
            int freq[] = new int[26]; //array to store the frequency of each string
            
            for(int j=i;j<s.length();j++) {
                char ch = s.charAt(j);
                freq[ch-'a']++; //to stor ethe frequency of each character of string
                sum += allSum(freq); 
            }
        }
        
        return sum;
        
    }
    
    //method to find the maximum and minimum in order to find the beauty
    public int allSum(int[] freq) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i: freq) {
            if(i != 0){
                max = Math.max(i, max);
                min = Math.min(i, min);
            }
        }
        
        return max-min;
        
        
    }
}