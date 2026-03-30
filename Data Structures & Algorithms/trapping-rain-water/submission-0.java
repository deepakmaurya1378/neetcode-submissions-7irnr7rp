class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int i = 1;
        int j = height.length-2;
        int[] l = new int[n];
        int[] r = new int[n];
       
        l[0] = height[0];
        r[n-1] = height[n-1];
        
        while(j>=0){
            r[j] = Math.max(height[j] , r[j+1]);
            j--;
        }
        while(i<n){
            l[i] = Math.max(height[i] , l[i-1]);
            i++;
        }
        int c = 0;
        for(i=0; i<n;i++){
            int x =  Math.min(l[i] , r[i]);
            c= c + x - height[i];
        }
        return c;
    }
}
