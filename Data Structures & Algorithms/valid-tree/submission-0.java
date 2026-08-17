class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v= edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited= new boolean[n];
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{0,-1});
        while(!q.isEmpty()){
            int[] front=q.poll();
            int node=front[0], parent=front[1];
            visited[node]=true;
            for(int neighbor:adj.get(node)){
                if(!visited[neighbor]){
                    q.offer(new int[]{neighbor,node});
                }else if(neighbor!=parent){
                    return false;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(!visited[i]) return false;
        }

        return true;
    }
}
