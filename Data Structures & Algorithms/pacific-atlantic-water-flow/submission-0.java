class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // traverse 1st row and 1st col -> see which cells can we reach from there
        // traverse last row and last col -> see which cells can we reach from there
        // cells reachable from both -> add it to our answer

        int rows= heights.length;
        int cols= heights[0].length;

        boolean[][] pacific= new boolean[rows][cols];
        boolean[][] atlantic=new boolean[rows][cols];

        int[] dr={1,0,-1,0};
        int[] dc= {0,1,0,-1};

        // 1st row
        for(int i=0;i<cols;i++){
            if(!pacific[0][i]){
                dfs(0,i,heights,pacific,dr,dc);
            }
        }
        // 1st col
        for(int i=0;i<rows;i++){
            if(!pacific[i][0]){
                dfs(i,0,heights,pacific,dr,dc);
            }
        }
        // last row
        for(int i=0;i<cols;i++){
            if(!atlantic[rows-1][i]){
                dfs(rows-1,i,heights,atlantic,dr,dc);
            }
        }
        // last col
        for(int i=0;i<rows;i++){
            if(!atlantic[i][cols-1]){
                dfs(i,cols-1,heights,atlantic,dr,dc);
            }
        }

        List<List<Integer>> res= new ArrayList<>();

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(new ArrayList<>(List.of(i,j)));
                }
            }
        }

        return res;
    }
    public void dfs(int row,int col,int[][] heights,boolean[][] visited,int[] dr,int[] dc){
        visited[row][col]=true;
        for(int i=0;i<4;i++){
            int nr= row+dr[i];
            int nc= col+dc[i];

            if(nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length && heights[nr][nc]>=heights[row][col] && !visited[nr][nc]){
                dfs(nr,nc,heights,visited,dr,dc);
            }
        }
    }
}
