class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> h = new HashSet<>();
        h.add(n);
        int s = 0;
        boolean t =  false;
        while(n != 1){

            while(n!=0){
                s = (n%10 )* (n%10) + s;
                n/=10;
            }
            n = s;
            s = 0;

            if(h.contains(n)){
                return false;
            }
            else{
                h.add(n);

            } 
        }


        return true;
        
    }
}
