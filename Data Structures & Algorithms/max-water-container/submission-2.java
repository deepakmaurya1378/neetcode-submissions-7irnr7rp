class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length-1;
        int k = 1;
        int m = 0;

        while (j>i){
            if( heights[i] < heights[j]){
                k = heights[i]* (j-i);
                i++;
            }
            else if ( heights[i] >= heights[j]){
                k = heights[j]*(j-i);
                j--;
            }
            m = Math.max(m, k);
        }
        return m;
    }
}
