class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] vis = new int[m][n];
        int c = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1' && vis[i][j] == 0){
                    c++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        return c;
    }
    void dfs(int r,int c,char[][] grid,int[][] vis){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length)
            return;
        if(grid[r][c] == '0' || vis[r][c] == 1) return;
        vis[r][c] = 1;
        dfs(r-1,c,grid,vis);
        dfs(r+1,c,grid,vis);
        dfs(r,c-1,grid,vis);
        dfs(r,c+1,grid,vis);
    }
}

