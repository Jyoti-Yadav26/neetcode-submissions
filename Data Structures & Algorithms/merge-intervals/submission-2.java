class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1) return intervals;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        ArrayList<int[]> res= new ArrayList<>();
        int start=intervals[0][0];
        int end= intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            int currStart= intervals[i][0];
            int currEnd = intervals[i][1];

            // overlapping condition
            if(end>=currStart){
                end= Math.max(end,currEnd);
            }else{
                res.add(new int[]{start,end});

                start= currStart;
                end= currEnd;
            }
        }
        // Add the last interval
        res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][]);
    }
}
