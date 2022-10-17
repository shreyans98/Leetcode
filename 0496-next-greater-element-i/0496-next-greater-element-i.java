class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
/*
Idea behind the approach is:
If we have a decresing array then we can keep on storing them in the stack till the time next greater number is not encountered.
When we encounter the next greater element then we will pop elements from stack till the number popped is smaller then that number and hence this greater number becomes the next greater element for all the numbers popped of.




*/
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<Integer> st = new Stack<Integer>();
        
        for(int num: nums2){
            while(!st.isEmpty() && st.peek() < num)
                map.put(st.pop(), num);
            st.push(num);
        }
            
            for(int i=0;i<nums1.length;i++)
                nums1[i] = map.getOrDefault(nums1[i], -1);
            
        
        return nums1;
    }
}