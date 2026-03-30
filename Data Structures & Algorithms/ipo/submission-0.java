class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // create min heap with minimum capital
        // capital , profit , index;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[2], b[2]);
            }
            return Integer.compare(a[0], b[0]);
        });

         PriorityQueue<int[]> maxprofit = new PriorityQueue<>((a,b) ->  b[1] - a[1] );

        int n = profits.length;

        for(int i = 0; i<n ;i ++){
            pq.offer(new int[]{capital[i] , profits[i] , i});
        }

        while(k>0 && (!pq.isEmpty() || !maxprofit.isEmpty())){
            if(!pq.isEmpty() &&pq.peek()[0] > w){  return w;    }

            while( !pq.isEmpty() && w >= pq.peek()[0]){
                maxprofit.offer(pq.poll());
            }
             int[] curr = maxprofit.poll();
             w += curr[1];
             System.out.println(w);
             k--;
        }

        return w;
    }
}