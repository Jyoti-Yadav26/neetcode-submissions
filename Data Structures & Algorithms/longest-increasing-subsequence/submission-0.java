class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, func(i, nums,dp));
        }

        return ans;
    }
    public int func(int i, int[] nums,int[] dp) {
        if (dp[i] != -1)
            return dp[i];

        int best = 1;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                best = Math.max(best, 1 + func(j, nums,dp));
            }
        }
        return dp[i] = best;
    }
}
