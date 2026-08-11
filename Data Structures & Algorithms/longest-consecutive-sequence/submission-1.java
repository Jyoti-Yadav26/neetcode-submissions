class Solution {
    public int longestConsecutive(int[] nums) {
        int n= nums.length;
        
        Set<Integer> set= new HashSet<>();
        for(int x:nums){
            set.add(x);
        }
        int maxLen=0;
        for(int x:set){
            if(!set.contains(x-1)){ // means x is the beginning of a sequence
                int curr=x;
                int len=1;

                while(set.contains(curr+1)){
                    len++;
                    curr++;
                }

                maxLen=Math.max(maxLen,len);
            }
        }

        return maxLen;
    }
}
