class Solution {
    public static boolean check(char c , char t){
        if( t== '(' && c== ')'){
            return true;
        }
        if(t == '{' && c== '}'){
            return true;
        }
        if(t == '[' && c== ']'){
            return true;
        }
        return false;
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
          if( s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}'){
            if( !stack.isEmpty() && check(s.charAt(i) , stack.peek()) ){
                stack.pop();
            }
            else{
               return false;
            }
          }
          else{
            stack.push(s.charAt(i));
          }
        }
        return stack.isEmpty();
        
    }
}
