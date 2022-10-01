class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //Brute force approach
        int temp = 0;
        //shift all the elements of nums2 to nums1 in the position where 0 occurs
        for(int i=m;i<nums1.length;i++) {
            nums1[i] = nums2[temp];
            temp++;
            }
        
        //sort the complete the nums1 array in non decreasing order
        for(int i=0;i<nums1.length-1;i++) {
            for(int j=i+1;j<nums1.length;j++) {
                if(nums1[i]>nums1[j]) {
                    temp = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = temp;
                }
            }
            
        }
        
    }
        
    }
