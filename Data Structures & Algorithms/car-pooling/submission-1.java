class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
     int track = 0;
     int n = trips.length;
     Arrays.sort(trips, (a, b) -> Integer.compare(a[1], b[1]));
     for(int i=0; i<n; i++){
        if(i > 0){
            if(trips[i-1][2] > trips[i][1]){
                track += trips[i][0];
            }
            else{
                track = trips[i][0];
            }
        }
        else if(i == 0){
            track = trips[i][0];
        }
        if(track > capacity) return false;
        System.out.println(track);
     }
     return true;
    }
}