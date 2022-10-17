class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int res[] = new int[nums1.length];
        for(int m=0;m<res.length;m++)
            res[m] = -1;
        
        for(int i=0;i<nums1.length;i++) {
            int temp = nums1[i];
            
            int j= 0;
            while(nums2[j] != nums1[i])
                j++;
            
            if(j>nums2.length-2)
                res[i] = -1;
            else {
                for(int k=j+1;k<nums2.length;k++) {
                    if(nums2[j] < nums2[k]){
                        res[i] = nums2[k];
                        break;
                    }
                        
                    
                }
            }
        }
        
        return res;
        
        
        
    }
}