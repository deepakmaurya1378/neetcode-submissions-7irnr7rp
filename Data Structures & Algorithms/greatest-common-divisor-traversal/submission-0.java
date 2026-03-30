class UnionFind {
    private int n;
    private int[] Parent;
    private int[] Size;

    public UnionFind(int n) {
        this.n = n;
        this.Parent = new int[n + 1];
        this.Size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            this.Parent[i] = i;
            this.Size[i] = 1;
        }
    }

    public int find(int node) {
        if (Parent[node] != node) {
            Parent[node] = find(Parent[node]);
        }
        return Parent[node];
    }

    public boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) return false;
        n--;
        if (Size[pu] < Size[pv]) {
            int temp = pu;
            pu = pv;
            pv = temp;
        }
        Size[pu] += Size[pv];
        Parent[pv] = pu;
        return true;
    }

    public boolean isConnected() {
        return n == 1;
    }
}

public class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
       int n = nums.length;
       UnionFind dsu = new UnionFind(n);
       HashMap<Integer, Integer> h = new HashMap<>();

       for(int i=0; i< n; i++){
        int num = nums[i];
        int f = 2;
        while(f*f <= num){
            if(num%f == 0){
                if(h.containsKey(f)){
                    dsu.union(i, h.get(f));
                }else{
                    h.put(f, i);
                }
                while(num % f == 0){
                    num /= f;
                }

            }
            f++;
        }

        if(num > 1){
            if(h.containsKey(num)){
                dsu.union(i, h.get(num));
            }
            else{
                h.put(num, i);
            }
        }
       }

        return dsu.isConnected();
    }
}