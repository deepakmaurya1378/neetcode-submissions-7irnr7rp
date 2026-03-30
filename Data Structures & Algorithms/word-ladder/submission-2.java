class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    int n = beginWord.length();

    HashSet<String> h = new HashSet<>();
    h.addAll(wordList);

    Queue<String> q = new LinkedList<>();
    
    q.add(beginWord);

    int count = 1;

    while(!q.isEmpty()){
        int size = q.size();
        for(int k=0; k<size; k++){
            StringBuilder s = new StringBuilder();
             String str = q.remove();

            s.append(str);

         System.out.println(1);

        if(str.equals(endWord)){
          System.out.println(s);
             return count;
            }

        h.remove(str);

        for(int i = 0; i < n; i++ ){
            char original = s.charAt(i);

            for (char ch = 'a'; ch <= 'z'; ch++) {
              if(ch == original){
                 System.out.println(3);
                 continue;
              }
             
                s.setCharAt(i, ch);
                String newword = s.toString();
            
                if(h.contains(newword)){

                q.add(newword);
                System.out.println(newword + " -> Count = " + count);
                h.remove(newword);
              }
            }
            s.setCharAt(i, original);
        
        }
        }
    
        count++;
    }
    return 0;

    }
}
