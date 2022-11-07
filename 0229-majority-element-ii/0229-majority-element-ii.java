class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int count1 = 0, count2 = 0, num1 = -1, num2 = -1, len = nums.length;
        
        for(int num : nums) {
            if(num == num1)
                count1++;
            else if(num == num2)
                count2++;
            
            else if(count1 == 0){
                num1 = num;
                count1 = 1;
            }
            
            else if(count2 == 0){
                num2 = num;
                count2 = 1;
            }
            
            else {
                count1--;
                count2--;
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        count1 = 0; 
        count2 = 0;
        
        for(int x: nums) {
            if(x == num1)
                count1++;
            else if(x == num2)
                count2++;
            
        }
        
        if(count1 > len/3)
            res.add(num1);
        if(count2 > len/3)
            res.add(num2);
        
        return res;
        
        
        
    }
}