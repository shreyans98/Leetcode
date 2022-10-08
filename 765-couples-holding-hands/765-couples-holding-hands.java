class Solution {
    public int minSwapsCouples(int[] row) {
        
/*
Intuition behind the approach:
For every odd number partner will be partner - 1
for every even number partner will be partner + 1

once partner is found we start from the next element, to check for the position of it and swap it in minimum steps



*/        
        int swaps = 0;
        int temp = 0;
        int partner = 0;
        
        for(int i =0;i<row.length-2;i+=2) {
            if(row[i] % 2 ==0)
                partner = row[i] + 1;
            else
                partner = row[i] -1;
            
            int j = i+1;
            
            //loop to find position of partner element
            while(row[j] != partner)
                j++;
            
            //if next person is partner itself hence skip the transaction
            if(j==i+1)
                continue;
            
            //swap the position value 
            temp = row[j];
            row[j] = row[i+1];
            row[i+1] = temp;
            
            swaps++;
                
        }
        
        return swaps;
        
    }
}