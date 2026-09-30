class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }
        while(low<=high){
            int mid= low+(high-low)/2;
            if(check(weights,mid,days)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return low;
    }
    public boolean check(int[] weights,int mid,int days){
        int neededDays=1;
        int current=0;

        for(int weight:weights){
            if(weight>mid) return false;

            if(current+weight>mid){
                neededDays++;
                current=0;
            }

            current+=weight;
        }

        return neededDays<=days;
    }
}