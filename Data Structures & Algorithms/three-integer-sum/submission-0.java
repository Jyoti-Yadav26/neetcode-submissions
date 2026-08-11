class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort the array
    int n = nums.length;

    for (int i = 0; i < n - 2; i++) {
        // Skip duplicates for i
        if (i > 0 && nums[i] == nums[i - 1]) continue;

        int low = i + 1;
        int high = n - 1;

        while (low < high) {
            int sum = nums[i] + nums[low] + nums[high];

            if (sum == 0) {
                // Create a new list for each triplet
                List<Integer> triplet = new ArrayList<>();
                triplet.add(nums[i]);
                triplet.add(nums[low]);
                triplet.add(nums[high]);
                res.add(triplet);

                // Skip duplicates for low and high
                while (low < high && nums[low] == nums[low + 1]) low++;
                while (low < high && nums[high] == nums[high - 1]) high--;

                low++;
                high--;
            } else if (sum < 0) {
                low++;
            } else {
                high--;
            }
        }
    }

    return res;
    }
}
