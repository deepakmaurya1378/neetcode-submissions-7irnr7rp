class Solution {
    class Pair{
        String lock;
        int step;
       Pair(String lock, int step){
            this.lock = lock;
            this.step = step;
}

    }
    public int openLock(String[] deadends, String target) {
        HashSet<String> h = new HashSet<>(Arrays.asList(deadends));
        Queue<Pair> q = new LinkedList<>();
        if(h.contains("0000")) { return  -1; }
        HashSet<String> l = new HashSet<>();

        q.add(new Pair("0000", 0));

        l.add("0000");

        while(!q.isEmpty()){
            Pair p = q.poll();
            String n = p.lock;
            int step = p.step;

            if( n.equals(target)){
                return step;
            }

           for (int i = 0; i < 4; i++) {
                char[] c = n.toCharArray();
                c[i] = (c[i] == '9') ? '0' : (char)(c[i] + 1);
                String next = new String(c);

                if (!h.contains(next) && !l.contains(next)) {
                    q.add(new Pair(next, step+1));
                    l.add(next);
                }
                c = n.toCharArray();
                c[i] = (c[i] == '0') ? '9' : (char)(c[i] - 1);
                next = new String(c);

                if (!h.contains(next) && !l.contains(next)) {
                     q.add(new Pair(next, step+1));
                    l.add(next);
                }
           }

        }
      return -1;
   }
}