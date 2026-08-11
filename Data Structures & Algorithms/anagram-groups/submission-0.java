class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map = new HashMap<>();

        for(String s:strs){
            char[] ch= s.toCharArray();
            Arrays.sort(ch);
            StringBuilder sb= new StringBuilder();
            for(char c:ch) sb.append(c);
            if(!map.containsKey(sb.toString())){
                map.put(sb.toString(),new ArrayList<>(List.of(s)));
            }else{
                ArrayList<String> temp= map.get(sb.toString());
                temp.add(s);
            }
        }
        List<List<String>> res= new ArrayList<>();
        for(Map.Entry<String,ArrayList<String>> entry:map.entrySet()){
            res.add(entry.getValue());
        }

        return res;
    }
}
