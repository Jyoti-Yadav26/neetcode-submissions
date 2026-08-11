class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> numChecker = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(numChecker.containsKey(nums[i])) return true;
            numChecker.put(nums[i],1);
        }
        return false;
    }
}