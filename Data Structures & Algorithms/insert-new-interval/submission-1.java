class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<ArrayList<Integer>> res= new ArrayList<>();

        int start= newInterval[0];
        int end= newInterval[1];
        boolean inserted= false; // tells whether the newInterval has already been inserted
        for(int[] window:intervals){
            int currStart= window[0];
            int currEnd= window[1];

            // intervals completely before the newInterval
            if(currEnd<start){
                res.add(new ArrayList<>(List.of(currStart,currEnd)));
            }else if(currStart>end){ // intervals completely after the newInterval
                if(!inserted){
                    res.add(new ArrayList<>(List.of(start,end)));
                    inserted= true;
                }
                res.add(new ArrayList<>(List.of(currStart,currEnd)));
            }else{  // overlapping
                start= Math.min(start,currStart);
                end= Math.max(end,currEnd);
            }
        }

        // if inserted= false,it means the intervals array has been finished yet newIntervals
        // isn't inserted -> meaning it comes at the end

        if(!inserted){
            res.add(new ArrayList<>(List.of(start,end)));
        }
        int size=res.size();
        int[][] ans= new int[size][2];

        for(int i=0;i<size;i++){
            ans[i][0]=res.get(i).get(0);
            ans[i][1]=res.get(i).get(1);
        }

        return ans;
    }
}
