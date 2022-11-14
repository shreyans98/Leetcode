class Solution {
    public String reverseOnlyLetters(String s) {
        
//         Stack<Character> letters = new Stack<>();
        
//         for(char c: s.toCharArray())
//             if(Character.isLetter(c))
//                 letters.push(c);
        
//         StringBuilder ans = new StringBuilder();
        
//         for(char c: s.toCharArray()) {
//             if(Character.isLetter(c))
//                 ans.append(letters.pop());
//             else
//                 ans.append(c);
//         }
        
//         return ans.toString();
        
        //2-pointer method
        
        
        StringBuilder res = new StringBuilder();
        int j = s.length()-1;
        
        for(int i=0;i<s.length();i++) {
            if(Character.isLetter(s.charAt(i))) {
                while(!Character.isLetter(s.charAt(j)))
                    j--;
                res.append(s.charAt(j--));
            }
            else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
        
    }
}