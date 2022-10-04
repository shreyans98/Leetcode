class Solution {
    public int fillCups(int[] amount) {
        
        Arrays.sort(amount);
        int days=0;
        while(amount[2] != 0) {
            days++;
            amount[2]--;
            amount[1]--;
            Arrays.sort(amount);
        }
        return days;
    }
}