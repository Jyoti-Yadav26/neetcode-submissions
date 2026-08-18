class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int len= times.length;
        List<List<int[]>> adj= new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<len;i++){
            int u= times[i][0];
            int v= times[i][1];
            int t= times[i][2];

            adj.get(u).add(new int[]{v,t});
        }

        int[] dist= new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)-> Integer.compare(a[1],b[1]));
        pq.add(new int[]{k,0});

        while(!pq.isEmpty()){
            int[] front= pq.poll();
            int node= front[0], currDist = front[1];

            // Ignore outdated entry
            if (currDist > dist[node]) continue;
            for(int[] neigh:adj.get(node)){
                int neighbor= neigh[0];
                int edgeWeight = neigh[1];
                if (dist[neighbor] > currDist + edgeWeight){
                    dist[neighbor]=currDist + edgeWeight;
                    pq.offer(new int[]{neighbor, dist[neighbor]});
                }
            }
        }
        int ans = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE)
                return -1;

            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}
