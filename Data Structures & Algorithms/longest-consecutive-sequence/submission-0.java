class Solution {
    public int longestConsecutive(int[] nums) {
        int n= nums.length;
        int len=1;
        int maxLen=1;
        TreeSet<Integer> set= new TreeSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        if(set.isEmpty()) return 0;
        Iterator<Integer> it=set.iterator();
        int prev=it.next();
        while(it.hasNext()){
            int curr=it.next();
            System.out.println(curr);
            if(curr-prev==1){
                len++;
            }else{
                len=1;
            }
            maxLen=Math.max(maxLen,len);
            prev=curr;
        }

        return maxLen;
    }
}
