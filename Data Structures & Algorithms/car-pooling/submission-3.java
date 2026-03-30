class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1001];  // constraint: location <= 1000
        
        for(int[] trip : trips){
            arr[trip[1]] += trip[0];  // pick up passengers
            arr[trip[2]] -= trip[0];  // drop off passengers
        }
        
        int currentPassengers = 0;
        
        for(int i = 0; i < 1001; i++){
            currentPassengers += arr[i];
            if(currentPassengers > capacity) return false;
        }
        
        return true;
    }
}