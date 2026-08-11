class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] prefixProd = new int[n];
        int[] suffixProd = new int[n];

        prefixProd[0] = nums[0];
        suffixProd[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            prefixProd[i] = prefixProd[i - 1] * nums[i];
            suffixProd[n - i - 1] = suffixProd[n - i] * nums[n - i - 1];
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int prefixVal = (i > 0) ? prefixProd[i - 1] : 1;
            int suffixVal = (i < n - 1) ? suffixProd[i + 1] : 1;

            res[i] = prefixVal * suffixVal;
        }

        return res;
    }
}
