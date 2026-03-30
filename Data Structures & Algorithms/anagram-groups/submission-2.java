class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    Map<String , List<String>> h = new HashMap<>();
    for(String s2 : strs ){
        int s1[] = new int[26];
        for(char c : s2.toCharArray()){
            s1[c-'a']++;
        }
        String s = Arrays.toString(s1);

        if(!h.containsKey(s)){
            h.put(s, new ArrayList<>());
        }
        h.get(s).add(s2);    
    }
    System.out.println(h.values());
    return new ArrayList<>(h.values());

    }
}
