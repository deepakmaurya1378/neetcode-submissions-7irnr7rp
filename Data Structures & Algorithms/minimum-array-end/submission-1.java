class Solution {
    public long minEnd(int n, int x) {
    long ans = x;
    long num = n-1;
    long bit = 0;

    while(num > 0){
        if((ans & (1L << bit)) == 0){
            if ((num & 1L) == 1) {
                ans |= (1L << bit);
            }
           num=num>>1;
        }
         bit++;
    }
    return ans;
    }
}

