class Solution {
    public int orangesRotting(int[][] grid) {
        int rows= grid.length;
        int cols= grid[0].length;
        
        boolean[][] visited= new boolean[rows][cols];
        Queue<int[]> q= new LinkedList<>();
        int[] dr={1,0,-1,0};
        int[] dc= {0,1,0,-1};
        int freshFruits=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!visited[i][j] && grid[i][j]==2){
                    q.offer(new int[]{i,j,0});
                }
                if(grid[i][j]==1){
                    freshFruits++;
                }
            }
        }
        int mTime=0;
        int fruitsRotten=0;
        while(!q.isEmpty()){
            int[] front=q.poll();
            int row=front[0], col= front[1], time=front[2];
            mTime= Math.max(mTime,time);
            for(int i=0;i<4;i++){
                int nr= row+dr[i];
                int nc= col+dc[i];

                if(nr>=0 && nc>=0 && nr<rows && nc<cols && !visited[nr][nc] && grid[nr][nc]==1){
                    q.offer(new int[]{nr,nc,time+1});
                    fruitsRotten++;
                    visited[nr][nc]=true;
                }
            }
        }
        //System.out.println(freshFruits+" "+fruitsRotten);

        return (freshFruits==fruitsRotten)?mTime:-1;
    }
}
