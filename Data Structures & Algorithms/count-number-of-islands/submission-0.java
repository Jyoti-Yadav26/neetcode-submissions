class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islands = 0;
        int[] dr = {0, -1, 0, 1};
        int[] dc = {-1, 0, 1, 0};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(i, j, grid, visited, dr, dc);
                    islands++;
                }
            }
        }

        return islands;
    }
    public void dfs(int row, int col, char[][] grid, boolean[][] visited, int[] dr, int[] dc) {
        // out of range
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return;
        }
        // already visited or is water
        if (visited[row][col] || grid[row][col] == '0') {
            return;
        }
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nRow = row + dr[i];
            int nCol = col + dc[i];

            if (nRow >= 0 && nCol >= 0 && nRow < grid.length && nCol < grid[0].length
                && !visited[nRow][nCol] && grid[nRow][nCol] == '1') {
                dfs(nRow, nCol, grid, visited, dr, dc);
            }
        }
        return;
    }
}
