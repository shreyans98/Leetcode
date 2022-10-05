class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {

        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<arr.length - 3;i++) {
            if(i != 0 && arr[i] == arr[i-1]) continue;
            for(int j=i+1;j<arr.length-2;j++) {
                
                if(j != i+1 && arr[j] == arr[j-1]) continue;

                int k = j+1, l = arr.length -1;
                double t = (double) target - arr[j] - arr[i];
                while(k < l) {
                    int sum = arr[k] + arr[l];
                    if(sum == t) {
                            result.add(Arrays.asList(arr[i],arr[j],arr[k],arr[l]));
                        
                        while(k < l && arr[k] == arr[k+1]) k++;
                        while(l > k && arr[l] == arr[l-1]) l--;
                        
                        k++;
                        l--;
                    }
                    else if(sum < t) k++;
                    else if(sum > t) l--;
                }
            }
        }
        return result;
    }
    
}