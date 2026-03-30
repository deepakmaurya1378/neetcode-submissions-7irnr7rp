class Solution {
    class DisjointSet{
        HashMap<String, Double> weight;
        HashMap<String, String>  parent;

        DisjointSet(){
            weight = new HashMap<>();
            parent = new HashMap<>();
        }

        public void add(String x){
            if(!parent.containsKey(x)){
            parent.put(x , x);
            weight.put(x, 1.0);
        }}

        public String find(String s) {
            if (!parent.get(s).equals(s)) {
                String origParent = parent.get(s);
                parent.put(s, find(origParent));
                weight.put(s, weight.get(s) * weight.get(origParent)); 
            }
            return parent.get(s);
        }


        public void Union(String s1, String s2, Double value){
             add(s1);
             add(s2);
            String ps1 = find(s1);
            String ps2 = find(s2);

            if(!ps1.equals(ps2)){
                parent.put(ps1, ps2);
                weight.put(ps1, value * weight.get(s2)/weight.get(s1));
            }
            return;
        }

        
        public Double getRatio(String x , String y){
            if(!parent.containsKey(x) || !parent.containsKey(y) || !find(x).equals(find(y))){
                return -1.0;
            }
            return weight.get(x)/weight.get(y);
        }

    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            DisjointSet d = new DisjointSet();

            for (int i = 0; i < equations.size(); i++) {
                 List<String> equation = equations.get(i);
                    String a = equation.get(0);
                    String b = equation.get(1);
                    d.Union(a, b, values[i]);
             }

            double ans[] = new double[queries.size()];

             for (int i = 0; i < queries.size(); i++) {
                 List<String> equation = queries.get(i);
                    String a = equation.get(0);
                    String b = equation.get(1);
                    ans[i] = d.getRatio(a, b);
                }
            return ans;
    }
}