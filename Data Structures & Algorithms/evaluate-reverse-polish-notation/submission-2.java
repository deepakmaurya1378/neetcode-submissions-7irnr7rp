class Solution {
    public static boolean checksign(String s){
        return s.equals("+") ||  s.equals("/") ||  s.equals("*") ||  s.equals("-");
    }

    public static int action(int a, int b, String op){
        switch(op){
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
        }return 0;
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(String t : tokens){
            if(checksign(t)){
                int x = s.pop();
                int y = s.pop();
                int res = action(y, x , t);
                s.push(res);
            }
            else{
                s.push(Integer.parseInt(t));
            }
        }
        return s.pop();
    }
}
