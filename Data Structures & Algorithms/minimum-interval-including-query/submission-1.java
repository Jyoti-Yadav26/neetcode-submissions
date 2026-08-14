class Solution {
    static final int INF= Integer.MAX_VALUE;
    public int[] minInterval(int[][] intervals, int[] queries) {
        int minLen=INF;
        int[] res= new int[queries.length];
        int[][] sortedQueries= new int[queries.length][2];
        for(int i=0;i<queries.length;i++){
            sortedQueries[i][0]=queries[i];
            sortedQueries[i][1]=i;
        }
        Arrays.sort(sortedQueries,(a,b)->Integer.compare(a[0],b[0]));
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        Arrays.sort(queries);
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));

        int ind=0;
        for(int i=0;i<sortedQueries.length;i++){
            int query= sortedQueries[i][0];
            int start=intervals[ind][0];
            int end= intervals[ind][1];
            while(ind<intervals.length-1 && start<=query){
                pq.add(new int[]{end,end-start+1});
                ind++;
                start=intervals[ind][0];
                end= intervals[ind][1];
            }
            if(start<=query){
                pq.add(new int[]{end,end-start+1});
            }
            while(!pq.isEmpty() && pq.peek()[0] < query){
                pq.poll();
            }

            res[sortedQueries[i][1]]=(pq.isEmpty())?-1:pq.peek()[1];
        }

        return res;
    }
}
