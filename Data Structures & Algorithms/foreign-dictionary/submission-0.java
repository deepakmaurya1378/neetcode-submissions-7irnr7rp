class Solution {
    public String foreignDictionary(String[] words) {
    HashMap<Character, HashSet<Character>> h = new HashMap<>();

     for (String w : words) {
            for (char c : w.toCharArray()) {
                h.putIfAbsent(c, new HashSet<>());
            }
        }

    int n = words.length;

    for(int i=1; i <n; i++){
        String s1 = words[i-1];
        String s2 = words[i];
        
        int m = Math.min(s1.length(), s2.length());
        boolean found = false;

        for (int j = 0; j < m; j++) {
            char c1 = s1.charAt(j);
            char c2 = s2.charAt(j);

            if(c1 != c2){
                h.get(c1).add(c2); 
                found = true;
                break;
            }
        }

        if (!found && s2.length() < s1.length()) return "";        
    }

    HashMap<Character, Integer> h1 = new HashMap<>();

    for(char c : h.keySet()){
      h1.put(c, 0);
    }

    for(char c : h.keySet()){
      for(char c1 : h.get(c)){
        h1.put(c1, h1.get(c1)+1);
      }
    }

    Queue<Character> q = new LinkedList<>();

    for(char c : h1.keySet()){
        if(h1.get(c) == 0){
            q.offer(c);
        }
    }

    StringBuilder sb = new StringBuilder();

    while(!q.isEmpty()){
        char curr = q.poll();
        sb.append(curr);

        for(char c : h.get(curr)){
            h1.put(c, h1.get(c) - 1);

            if(h1.get(c) == 0){
                q.add(c);
            }
        }
    }

    if(sb.length() != h.size()) return "";

    return sb.toString();
    }
}
