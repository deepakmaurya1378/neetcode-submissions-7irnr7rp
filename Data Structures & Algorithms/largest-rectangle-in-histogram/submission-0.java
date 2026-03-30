
class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<int[]> s = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            int start = i;

            while (!s.isEmpty() && s.peek()[0] > heights[i]) {
                int[] popped = s.pop();
                int height = popped[0];
                int index = popped[1];
                max = Math.max(max, height * (i - index));
                start = index; 
            }

            s.push(new int[]{heights[i], start});
        }

       while(!s.isEmpty()){
        int[] popped = s.pop();
        int height = popped[0];
        int index = popped[1];
        max = Math.max(max, height*(heights.length - index));
       }

        return max;
    }
}
