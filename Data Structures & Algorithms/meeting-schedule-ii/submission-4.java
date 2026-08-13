/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n=intervals.size();
        int[] start= new int[n];
        int[] end= new int[n];

        for(int i=0;i<n;i++){
            start[i]=intervals.get(i).start;
            end[i]=intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);
        int rooms=0;
        int maxRooms=0;
        int s=0,e=0;
        while(s<n){
            int currEnd=end[e];
            if(start[s]<currEnd){ // overlapping
                rooms++;
                s++;
            }else{
                e++;
                rooms--;
            }
            maxRooms=Math.max(maxRooms,rooms);
        }

        return maxRooms;
    }
}
