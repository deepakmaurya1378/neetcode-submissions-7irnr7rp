public class Solution {
    private HashMap<Integer, Integer> dp = new HashMap<>();

    public int tribonacci(int n) {
        if (n <= 2) {
            return n == 0 ? 0 : 1;
        }
        if (dp.containsKey(n)) {
            return dp.get(n);
        }

        dp.put(n, tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3));
        return dp.get(n);
    }
}