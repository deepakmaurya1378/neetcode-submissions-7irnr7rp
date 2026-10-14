class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1 || n == 0){ return 0;  }
        int profit = 0;

        for(int i = 0; i <n-1; i++){
            if(prices[i] > prices[i+1]){
               continue;
            }
            else{
                int max = prices[i+1] - prices[i];
                int j = i;
                while(prices[i]-prices[j+1] > 0){
                    j++;
                    max = Math.max(max, prices[i] - prices[j]);
                    if(j == n){
                        break;
                    }
                }
                profit = profit + max;
            }
        }

        return profit;
    }
}