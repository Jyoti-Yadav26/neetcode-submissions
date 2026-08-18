class Solution {
    public int climbStairs(int n) {
        int[] dp= new int[n+1];
        Arrays.fill(dp,-1);
        return func(0,n,dp);
    }
    public int func(int i,int n,int[] dp){
        if(i==n) return 1;
        if(i>n) return 0;

        if(dp[i]!=-1) return dp[i];
        int oneStep=func(i+1,n,dp);
        int twoStep=func(i+2,n,dp);

        return dp[i] = oneStep+twoStep;
    }
}
