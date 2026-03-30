class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int a[] = new int[n];
        Stack<int[]> s = new Stack<>();
        
        for(int i = 0; i < n; i++){
            while( !s.isEmpty() && s.peek()[0] < temperatures[i]){
                int[] pair = s.pop();
                a[pair[1]] = i - pair[1];
            }
           s.push(new int[]{temperatures[i] , i});
        }
        return a;
    }
}
