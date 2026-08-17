class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int components=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,adj,visited);
                components++;
            }
        }

        return components;
    }
    public void dfs(int i,List<List<Integer>> adj,boolean[] visited){
        visited[i]=true;

        for(int neighbor:adj.get(i)){
            if(!visited[neighbor]){
                dfs(neighbor,adj,visited);
            }
        }

        return;
    }
}
