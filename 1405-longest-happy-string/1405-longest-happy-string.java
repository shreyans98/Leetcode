class Solution {
    public String longestDiverseString(int a, int b, int c) {
        String res = "";
        
        int a_count =0;
        int b_count = 0;
        int c_count = 0;
        
        StringBuilder sb = new StringBuilder();
        int maxLength = a+b+c;
        for(int i=0;i<maxLength;i++) {
            if((a>=b && a>=c && a_count < 2) || (c_count==2 && a>0) || (b_count==2 && a>0)) {
                sb.append('a');
                b_count = 0;
                c_count = 0;
                a_count++;
                a--;
            }
            
            else if((b>=a && b>=c && b_count < 2) || (c_count ==2 && b>0) || (a_count ==2 && b>0)) {
                sb.append('b');
                a_count = 0;
                c_count = 0;
                b_count++;
                b--;
            }
            
            else if((c>=b && c>=a && c_count < 2) || (a_count == 2 && c>0) || (b_count == 2 && c>0)) {
                sb.append('c');
                b_count = 0;
                a_count = 0;
                c_count++;
                c--;
                
            }  
        }
        return sb.toString();
        
    }
}