class Solution {

    public boolean dfs(HashMap<Integer, List<Integer>> a,
                       boolean[] vis,
                       boolean[] pathvis,
                       Stack<Integer> s,
                       int i) {

        if (pathvis[i]) return true;   // cycle
        if (vis[i]) return false;

        vis[i] = true;
        pathvis[i] = true;

        if (a.containsKey(i)) {
            for (int n : a.get(i)) {
                if (dfs(a, vis, pathvis, s, n)) {
                    return true;      // propagate cycle
                }
            }
        }

        pathvis[i] = false;
        s.push(i);
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> a = new HashMap<>();

        for (int[] p : prerequisites) {
            a.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] pathvis = new boolean[numCourses];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (dfs(a, vis, pathvis, s, i)) {
                    return new int[0];   // ❌ cycle found
                }
            }
        }

        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[numCourses-1-i] = s.pop();
        }
        return ans;
    }
}
