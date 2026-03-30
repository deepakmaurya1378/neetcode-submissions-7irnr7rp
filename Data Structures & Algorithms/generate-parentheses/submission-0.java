class Solution {
    public static List<String>  p(List<String> a ,  int n, int c1, int c2 , StringBuilder s){
        if(n*2 == s.length() && s.charAt(n*2 - 1) == ')') {
            a.add(s.toString());
            return a;
        }
        if(c1 < n){
        s.append("(");
        c1++;
        p(a, n , c1, c2, s);
        s.deleteCharAt(s.length() - 1);
        c1--;
        }
        if (c2 < n && c2 < c1){
        s.append(")");
        c2++;
        p(a, n , c1, c2, s);
        s.deleteCharAt(s.length() - 1);
        c2--;
        }
        return a;
    }
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder("(");
        List<String> a = new ArrayList<>();
        return p(a, n, 1, 0, sb);
    }
}
