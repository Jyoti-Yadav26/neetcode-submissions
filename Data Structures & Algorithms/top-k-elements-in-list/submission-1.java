class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        // Count frequencies
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // bucket[i] = numbers appearing i times
        List<Integer>[] bucket = new List[nums.length + 1];

        for (int num : freq.keySet()) {

            int count = freq.get(num);

            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }

            bucket[count].add(num);
        }

        int[] result = new int[k];
        int index = 0;

        for (int count = bucket.length - 1;
             count >= 0 && index < k;
             count--) {

            if (bucket[count] != null) {

                for (int num : bucket[count]) {

                    result[index++] = num;

                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}
