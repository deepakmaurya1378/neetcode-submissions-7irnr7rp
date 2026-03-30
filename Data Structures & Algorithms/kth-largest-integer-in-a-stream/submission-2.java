class KthLargest {
   PriorityQueue<Integer> pq;
   int k;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;
        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }  
        return; 
    }
    
    public int add(int val) {
        pq.offer(val);

        if(pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
}
