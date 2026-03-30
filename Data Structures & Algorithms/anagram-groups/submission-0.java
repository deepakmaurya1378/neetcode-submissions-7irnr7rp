class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> h = new HashMap<>();
    //creating map for the anagarm 
    for(String s : strs){ // taking  each string as s
        int[] count = new int[26];
        for(char c : s.toCharArray() ){ // converting s string to character array
            count[c-'a']++; 
        }

        String k = Arrays.toString(count); // converting count array to string to get the unqui value for each anagram
        if(!h.containsKey(k)){
            h.put(k, new ArrayList<>()); //if we get unqui array the we will add to hashmap and create new arraylist along side without add any value to it.
        }
        h.get(k).add(s); // adding string value according to the key k to arraylist.
    }
    return new ArrayList<>(h.values()); // assigning list to list
        
    }
}
