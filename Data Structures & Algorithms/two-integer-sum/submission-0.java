class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> check=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int remaining=target-nums[i];
            if(check.containsKey(remaining)){
                return new int[] {check.get(remaining), i};
            }
            check.put(nums[i],i);
        }
        return new int[0];
    }
}
