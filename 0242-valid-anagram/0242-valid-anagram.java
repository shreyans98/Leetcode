class Solution {
    public boolean isAnagram(String s, String t) {
        
        int a[] = new int[26];
        
        for(int i=0;i<s.length();i++) {
            int num1 = s.charAt(i) - 'a';
            a[num1]++;
        }
        
        for(int j=0;j<t.length();j++) {
            int num2 = t.charAt(j) - 'a';
            a[num2]--;
        }
        
        for(int k : a)
            if(k !=0)
                return false;
        
        return true;
        
    }
}