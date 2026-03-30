class Solution {
    public String reorganizeString(String s) {
       PriorityQueue<int[]> pq = 
    new PriorityQueue<>((a,b) -> b[1] - a[1]);

        int[] a = new int[26];
        for(char c : s.toCharArray()){
            a[c-'a']++;
        }

        for(int i =0 ; i<26; i++){
            if(a[i] > 0){
                pq.offer(new int[]{i, a[i]}); 
            }
        }

        StringBuilder sb = new StringBuilder();

        while(pq.size() > 1){
            int[] first = pq.poll();
            int[] second = pq.poll();

            sb.append((char)('a'+ first[0]));
            sb.append((char)('a'+ second[0]));

            if(--first[1] >0){
                pq.offer(first);
            }
            if(--second[1]>0){
                pq.offer(second);
            }
        }
         if(!pq.isEmpty()){
            int[] last = pq.poll();
            if(last[1] > 1) return "";
            sb.append((char)('a' + last[0]));
        }

        return sb.toString();
     
    }
}