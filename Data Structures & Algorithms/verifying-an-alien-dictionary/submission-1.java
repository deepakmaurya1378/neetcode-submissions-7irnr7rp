class Solution {
    public boolean isAlienSorted(String[] words, String order) {
       if(words.length == 1) return true;

        for(int i = 1; i < words.length; i++){
            String curr = words[i];
            String prev = words[i-1];

            int m = Math.min(curr.length(), prev.length());
            boolean found = false;

            for(int j=0; j < m ; j++){
                char c2 = curr.charAt(j);
                char c1 = prev.charAt(j);
                if(c1 != c2){
                    if(order.indexOf(c1) > order.indexOf(c2)){
                        return false;
                    }
                    found = true;
                    break;
                }

            }

            if(!found && prev.length() > curr.length()){
                return false;
            }

        }

        return true;
    }
}