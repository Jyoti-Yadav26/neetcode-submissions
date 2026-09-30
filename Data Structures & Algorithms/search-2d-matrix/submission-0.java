class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        
        for(int i=0;i<m;i++){
            int low=0;
            int high= n-1;

            while(low<=high){
                int mid= low+(high-low)/2;
                int val=matrix[i][mid];
                if(val==target){
                    return true;
                }else if(val>target){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
        }

        return false;
    }
}
