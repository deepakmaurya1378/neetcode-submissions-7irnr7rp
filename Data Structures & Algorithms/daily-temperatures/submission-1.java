class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
       int n  = temperatures.length;
       Stack<Integer> s = new Stack<>();
       int a[] = new int[n];

       for(int i = 0; i < n; i++){
        while (!s.isEmpty() && temperatures[s.peek()] < temperatures[i] ){
            a[s.peek()] = i - s.pop(); 
        }
        s.push(i);
       }
       return a;
    }
}
