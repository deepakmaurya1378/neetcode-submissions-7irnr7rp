class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int num = 2; num <= n; num++) {
            int max = 0;
            for (int i = 1; i < num; i++) {
                int notBreak = i * (num - i);
                int breakFurther = i * dp[num - i];

                max = Math.max(max, Math.max(notBreak, breakFurther));
            }
            dp[num] = max;
        }
        return dp[n];
    }
}