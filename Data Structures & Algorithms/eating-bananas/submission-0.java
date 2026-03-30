class Solution {
   public static int count(int[] piles, int k) {
        int hours = 0;
        for (int p : piles) {
                hours += Math.ceil((double) p / k);
            }
        return hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int j = 0;
        for(int i = 0; i < piles.length; i++){
            j = Math.max(j , piles[i]);
        }

        int i = 0;
        int min = j;
        while (j >= i){
            int m = (j+i)/2;
            int k = count(piles, m);
            if( k  <= h){
                j=m-1;
                min = m;
                System.out.println("j" + min);
            }
            else {
                i = m+1;
                 System.out.println(min);
            }
        }
        return min;
    }
}
