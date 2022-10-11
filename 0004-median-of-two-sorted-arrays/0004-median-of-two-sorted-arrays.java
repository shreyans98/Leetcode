class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums2.length < nums1.length)
            return findMedianSortedArrays(nums2, nums1);
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        int low = 0;
        int high = len1;
        
        while(low<=high) {
            //partition for the smaller array
            int cut1 = low + (high-low)/2;
            //partition for the right array
            int cut2 = (len1+len2+1)/2 - cut1;
            
            //left part of first array
            int left1 = (cut1==0) ? Integer.MIN_VALUE : nums1[cut1-1];
            //left part of second array
            int left2 = (cut2 ==0) ? Integer.MIN_VALUE : nums2[cut2-1];
            
            //right part of first array
            int right1 = (cut1 == len1) ? Integer.MAX_VALUE : nums1[cut1];
            //right part of second array
            int right2 = (cut2 == len2) ? Integer.MAX_VALUE : nums2[cut2];
            
            
            if(left1 <= right2 && left2 <= right1) {
                if((len1+len2) % 2 == 0) //for even number of elements
                    return (Math.max(left1, left2) + Math.min(right1, right2))/2.0;
                else
                    return Math.max(left1, left2);
            }
            
            else if(left1 > right2) //if left side is greater it means we have to go for numbers which are smaller i.e more numbers from secondd array and less numbers from first array
                high = cut1-1;
            else 
                low = cut1 + 1;
        }
        
        return 0.0;
        
    }
}