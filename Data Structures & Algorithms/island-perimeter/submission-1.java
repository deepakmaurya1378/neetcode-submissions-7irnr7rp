class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int perimeter = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;

                    if (i + 1 < n && grid[i + 1][j] == 1) perimeter -= 2;
                    if (j + 1 < m && grid[i][j + 1] == 1) perimeter -= 2;
                }
            }
        }
        return perimeter;
    }
}
