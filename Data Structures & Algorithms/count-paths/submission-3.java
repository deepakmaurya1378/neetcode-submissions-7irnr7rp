class Solution {
    public int uniquePaths(int m, int n) {
       int prev[] = new int[n];
       for(int i = 0; i< n; i++){
        prev[i] = 1;
       }

       for(int i=1; i<m; i++){
        for(int j=0; j<n; j++){
            int down = prev[j];
            int right = 0;

            if(j < n && j > 0){
                right = prev[j-1];
            }
            prev[j] = down + right;

        }
       }

       return prev[n-1];
    }
}
