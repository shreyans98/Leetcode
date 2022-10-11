class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
//Brute force approach. Combine 2 arrays and then find the median
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        int res[] = new int[len1+len2];
        
        int i=0;
        int j=0;
        int k = 0;
        
        while(i<len1 && j<len2) {
            if(nums1[i] < nums2[j]){
                res[k] = nums1[i];
                k++;
                i++;
            }
            
            else if(nums1[i] > nums2[j]){
                res[k] = nums2[j];
                k++;
                j++;
            }
            
            else{
                res[k] = nums1[i];
                k++;
                i++;
            }
        }
        
        while(i <len1){
            res[k] = nums1[i];
            k++;
            i++;
        }
        
        while(j<len2) {
            res[k] = nums2[j];
            k++;
            j++;
        }
        
        int len = res.length;
        double median = 0;
        
        if(len % 2 == 0) 
            median = (res[(len/2)-1] + res[(len/2)])/2;
        
        else
            median = (res[((len+1)/2)-1]);
        
        return median;
        
    }
}
