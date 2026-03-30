class MinStack {
    private Stack<Integer> s;
    private Stack<Integer> m;
    
    public MinStack() {
        s = new Stack<>();
        m = new Stack<>();
        
    }
    
    public void push(int val) {
        if(s.isEmpty()){
            s.push(val);
            m.push(val);
        }
        else{
            if(!m.isEmpty() && val <= m.peek()){
                m.push(val);
            }
            s.push(val);
        }
    }
    
    public void pop() {
        if(s.isEmpty()) return;
        if(s.peek().equals(m.peek())){
            m.pop();
        }
        s.pop();
    }
    
    public int top() {
        return  s.peek();
    }
    
    public int getMin() {
            return m.peek();
    }
}
