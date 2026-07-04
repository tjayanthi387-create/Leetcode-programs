class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] vis = new int[m][n];
        int maxArea = 0; 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    int currentArea = dfs(i, j, grid, vis);
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }
        return maxArea;
    }
    int dfs(int r, int c, int[][] grid, int[][] vis) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) return 0;                                                                  
        if (grid[r][c] == 0 || vis[r][c] == 1) return 0;
        vis[r][c] = 1;
        return 1 + dfs(r - 1, c, grid, vis)
                 + dfs(r + 1, c, grid, vis)
                 + dfs(r, c - 1, grid, vis)
                 + dfs(r, c + 1, grid, vis);
    }
}