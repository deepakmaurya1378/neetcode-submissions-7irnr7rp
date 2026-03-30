class Solution {
    public boolean dfs(HashMap<Integer, List<Integer>> a,
                   boolean[] vis,
                   boolean[] pathvis,
                   int i) {

    if (pathvis[i]) return true;
    if (vis[i]) return false;

    vis[i] = true;
    pathvis[i] = true;

    if (a.containsKey(i)) {
        for (int n : a.get(i)) {
            if (!vis[n]) {
                if (dfs(a, vis, pathvis, n)) return true;
            }
            else if (pathvis[n]) {   
                return true;
            }
        }
    }

    pathvis[i] = false;
    return false;
}


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        HashMap<Integer, List<Integer>> a = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];

            if (!a.containsKey(course)) {
                a.put(course, new ArrayList<>());
            }

            a.get(course).add(prereq);
        }  

        boolean[] vis = new boolean[numCourses];
        boolean[] pathvis = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){

           if(!vis[i]){  if(dfs(a , vis, pathvis, i)){  return false; }
            }

        }
        return true;
    }

}
