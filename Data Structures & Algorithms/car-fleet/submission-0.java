class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        HashMap<Integer, Integer> h1 = new HashMap<>();
        for(int i = 0; i < position.length;i++){
            h1.put(position[i] , speed[i]);
        }
        TreeMap<Integer, Integer> h = new TreeMap<>(Comparator.reverseOrder());
        h.putAll(h1);

        Stack<Double> s = new Stack<>();

        for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
            int x = entry.getKey();
            int y = entry.getValue();
            double time = (double)(target - x)/y;

            if(s.isEmpty() || time > s.peek()){
                s.push(time);
            }


        }
        return s.size();
    }
}
