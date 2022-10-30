class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        
        int len1 = str1.length();
        int len2 = str2.length();
        
        int dp[][] = new int[len1+1][len2+1];
        
        //base case
        for(int i=0;i<=len1;i++)
            dp[i][0]= 0;
        
        for(int j=0;j<=len2;j++)
            dp[0][j] = 0;
        
        
        for(int i=1;i<=len1;i++) {
            for(int j=1;j<=len2;j++) {
                
                char c1 = str1.charAt(i-1);
                char c2 = str2.charAt(j-1);
                
                if(c1 == c2)
                    dp[i][j] = 1 + dp[i-1][j-1];
                
                else
                    dp[i][j] = 0 + Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        int i = len1;
        int j = len2;
        
        String ans = "";
        
                
        while (i > 0 && j > 0) {
            
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
              ans += str1.charAt(i-1);
              i--;
              j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans += str1.charAt(i-1);
                i--;
            } else {
                ans += str2.charAt(j-1);
                j--;
            }
          }

          //Adding Remaing Characters - Only one of the below two while loops will run 

          while(i>0){
              ans += str1.charAt(i-1);
              i--;
          }
          while(j>0){
              ans += str2.charAt(j-1);
              j--;
          }

          String ans2=new StringBuilder(ans).reverse().toString();

          return ans2;

        
        
    }
}