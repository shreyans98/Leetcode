class Solution {
    public int findMinArrowShots(int[][] points) {
        
        if (points.length ==0)
            return 0;
        
        
        //Sort the array to find the overlap
        Arrays.sort(points, (a, b) -> Integer.compare(a[1],b[1]));
        
        int count = 1;
        int point = points[0][1];
        
        for(int i=1;i<points.length;i++) {
            if(point < points[i][0]) {
                count++;
                point = points[i][1];
            }
        }
        
        return count;
        
      
    }
}