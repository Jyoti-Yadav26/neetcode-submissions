class Solution {
    static final int INF= Integer.MAX_VALUE;
    public void islandsAndTreasure(int[][] grid) {
        int rows=grid.length;
        int cols= grid[0].length;
        boolean[][] visited= new boolean[rows][cols];
        int[] dr={1,0,-1,0};
        int[] dc= {0,1,0,-1};
        Queue<int[]> q= new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==0 && !visited[i][j]){
                    q.offer(new int[]{i,j,0});
                }
            }
        }

        while(!q.isEmpty()){
            int[] front=q.poll();
            int row=front[0], col= front[1], dist=front[2];
            for(int i=0;i<4;i++){
                int nr= row+dr[i];
                int nc= col+dc[i];

                if(nr>=0 && nc>=0 && nr<rows && nc<cols && !visited[nr][nc] && grid[nr][nc]==INF){
                    q.offer(new int[]{nr,nc,dist+1});
                    grid[nr][nc]=dist+1;
                    visited[nr][nc]=true;
                }
            }
        }
        return;
    }
}
