class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Greedy
        // Max heap
        // Queue (cooldown)
        // Time simulation
        // Edge case handling

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : tasks) {  map.put(c, map.getOrDefault(c, 0) + 1); }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.addAll(map.values());

        Queue<int[]> q = new ArrayDeque<>(); 

        int time = 0;

        while(!pq.isEmpty() || !q.isEmpty()){
            time++;

            if(!pq.isEmpty()){
                int freq = pq.poll();
                freq--;
                if(freq > 0){
                    q.add(new int[]{freq , time+n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time){
                pq.add(q.poll()[0]);
            }
        }

        return time;
    }
}