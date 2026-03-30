class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = 
    new PriorityQueue<>((x,y) -> y[0] - x[0]);
        if(a > 0){
            pq.offer(new int[]{a, 0});
        }
         if(b > 0){
            pq.offer(new int[]{b, 1});
        }
         if(c > 0){
            pq.offer(new int[]{c, 2});
        }

        StringBuilder sb = new StringBuilder();

        while(pq.size() > 1){
            int[] first = pq.poll();
            int n= sb.length();
            if(sb.length() > 1 && sb.charAt(n-1) == (char)('a' + first[1]) && sb.charAt(n-1) == sb.charAt(n-2)){
                if(pq.isEmpty())  break;

                int[] next = pq.poll();
                sb.append((char) ('a' + next[1]));
                if(--next[0] >0){
                    pq.offer(next);
                }
            }

             sb.append((char) ('a' + first[1]));
             if(--first[0]>0){
                pq.offer(first);
             }
        }

        if(!pq.isEmpty()) sb.append((char)('a'+pq.peek()[1]));

        return sb.toString();
        
    }
}