class Solution {
    public int lengthOfLongestSubstring(String s) {
         HashSet<Character> hs = new HashSet<>();
        int i = 0, j = 0, max = 0;
        while (j < s.length()) {
            if (!hs.contains(s.charAt(j))) {
                hs.add(s.charAt(j));
                max = Math.max(max, j - i + 1);
                j++;
            } else {
                hs.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}
