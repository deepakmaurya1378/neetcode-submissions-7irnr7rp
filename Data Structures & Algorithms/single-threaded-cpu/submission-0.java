class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> enqueheap = new PriorityQueue<>((a,b)-> a[0] - b[0]);

        for(int i=0; i< tasks.length; i++){
            enqueheap.add(new int[]{tasks[i][0] , tasks[i][1] , i});
        }

       PriorityQueue<int[]> pending = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[2], b[2]); 
            }
            return Integer.compare(a[1], b[1]);  });

        int[] ans = new int[tasks.length];

        long time = 0;
        int index = 0;
        while (!enqueheap.isEmpty() || !pending.isEmpty()) {
            
            if (pending.isEmpty() && !enqueheap.isEmpty()) {
                time = Math.max(time, enqueheap.peek()[0]);
            }

            while(!enqueheap.isEmpty() && time >= enqueheap.peek()[0]){
                pending.add(enqueheap.poll());
            }

              if (!pending.isEmpty()) {
                int[] a = pending.poll();
                ans[index++] = a[2];
                time += a[1];
            }
                
        }    


        return ans;
    }
}