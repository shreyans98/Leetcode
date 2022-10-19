class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0, right = 0;
        int len = fruits.length;
        
        int maxPicked = 0;
        //hashmap to store the frequency
        Map<Integer, Integer> hmap = new HashMap<>();
        
        while(right < len) {
            //we will move the right pointer till the end and push every element to the map if it is new or update the frequency which is stored as value
            hmap.put(fruits[right], hmap.getOrDefault(fruits[right], 0)+1);
            
            //when size crosse 2 then we will iterate and reduce the frequency of the element that is left most and finally remove it
            while(hmap.size() >2) {
                hmap.put(fruits[left], hmap.get(fruits[left])-1);
                
                if(hmap.get(fruits[left])==0)
                    hmap.remove(fruits[left]);
                left++;
            }
            //to find the max
            maxPicked = Math.max(maxPicked, (right-left+1));
            right++;
            
            
        }
        return maxPicked;
        
    }
}