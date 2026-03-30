
class Solution {
    public int largestRectangleArea(int[] heights) {
       int max = 0;
       Stack<Integer> s = new Stack<>();

       for(int i = 0; i <= heights.length; i++){
          while(!s.isEmpty() && (i == heights.length || heights[s.peek()] > heights[i])){
            int h = heights[s.pop()];
            int w = !s.isEmpty() ? i - s.peek() - 1 : i;

            max = Math.max(max , h*w);
          }
          s.push(i);
       }
       return max;
    }
}
