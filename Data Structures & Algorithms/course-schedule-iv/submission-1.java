class Solution {
    private ArrayList<ArrayList<Integer>> a;

    public boolean dfs(int src, int target, boolean[] vis){
        if(src == target) return true;
        vis[src] = true;
        for(int nei : a.get(src)){
            if(!vis[nei] && dfs(nei, target, vis)) return true;
        }
        return false;
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        a = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            a.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            a.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        List<Boolean> b = new ArrayList<>();
        for(int[] q : queries){
            b.add(dfs(q[0], q[1], new boolean[numCourses]));
        }

        return b;
    }
}
