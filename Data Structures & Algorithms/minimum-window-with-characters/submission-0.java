class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character , Integer> h = new HashMap<>();
        HashMap<Character , Integer> n = new HashMap<>();

        for (char c : t.toCharArray()) {
            h.put(c, h.getOrDefault(c, 0) + 1);
        }

        int have = 0; 
        int need = h.size();
        int len = Integer.MAX_VALUE;
        int[] a = {-1, -1};
        int i = 0;

        for(int  j = 0; j < s.length(); j++){
            char c = s.charAt(j);
            n.put(c, n.getOrDefault(c , 0)+1);

            if(h.containsKey(c) && n.get(c).equals(h.get(c))){
                have++;
            }

            while(have == need){
                if(len > j-i+1){
                    len = j-i+1;
                    a[0] = i;
                    a[1] = j;
                }

                char k = s.charAt(i);
                n.put(k , n.get(k) -1);
                if(h.containsKey(k) && n.get(k) < h.get(k)){
                    have--;
                }
                i++;
            }   
        }    
        return len == Integer.MAX_VALUE ? "" : s.substring(a[0], a[1] + 1);

    }
}
    