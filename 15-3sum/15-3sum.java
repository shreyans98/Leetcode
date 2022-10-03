class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-2;i++) { //we will take the constant i upto second last place
            
            //to avoid duplication of values at ith place
            if(i==0 || (i>0 && nums[i] != nums[i-1])){ //
                int lo = i+1, hi = nums.length - 1, target = 0-nums[i];
            
            while(lo < hi) {
                if(nums[lo] + nums[hi] == target) {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                
                while(lo<hi && nums[lo] == nums[lo+1]) //to avoid duplication of values at lo place
                    lo++;
                
                while(hi>lo && nums[hi] == nums[hi-1])//to avoid duplication of values at hi
                    hi--;
                lo++;
                hi--;
            }
                
                else if(nums[lo] + nums[hi] < target) //if less than the target, we have to increase lo since array is sorted
                    lo++;
                else
                    hi--; //if greater than decrease hi
                
        }
            }
        }
        
        return res;
        
    }
}