class Solution {
    public int missingNumber(int[] nums) {
        int n = 0;
        int c = 0;
        for(int i : nums){
            n ^= i;
            n ^= c;
            c++;
        }

        n^=c;
        return n;

        
    }
}
