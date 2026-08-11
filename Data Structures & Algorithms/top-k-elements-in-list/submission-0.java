class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n=nums.length;

        // build frequency map
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        // convert entries to list
        List<Map.Entry<Integer, Integer>> list =new ArrayList<>(map.entrySet());

        // sort by values descending
        list.sort((a,b)-> Integer.compare(b.getValue(),a.getValue()));

        // take first k keys
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i] = list.get(i).getKey();
        }
        return res;
    }
}
