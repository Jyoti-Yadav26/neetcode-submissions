class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp= new int[n];
        Arrays.fill(dp,-1);

        return Math.min(func(0,cost,dp),func(1,cost,dp));
    }
    public int func(int i,int[] cost,int[] dp){
        if(i>=cost.length) return 0;
        if(dp[i]!=-1) return dp[i];

       int one= cost[i]+func(i+1,cost,dp);
       int two= cost[i]+func(i+2,cost,dp);

       return dp[i] = Math.min(one,two);
    }
}
