class Solution {
    public int maxProfit(int[] prices) {
       int n = prices.length-1;
       int i = 0;
       int j = 1;
       int max = 0;
       while (j <= n){
        if(prices[j] > prices[i]){
           int sub = prices[j] - prices[i];
           if(max < sub ){
            max = sub;
           }
           j++;
       }
       else{
        i = j;
        j = j+1;
       }
    }
      return max;
    }
}
