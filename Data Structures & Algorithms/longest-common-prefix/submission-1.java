class Solution {
    public String longestCommonPrefix(String[] strs) {
        String s = strs[0];
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            int j = 0;
            boolean issub = true;
            while (j < strs.length) {
                if (i < strs[j].length() && strs[j].charAt(i) == s.charAt(i)) {
                    j++;
                } else {
                    issub = false;
                    j++;
                }
            }
            if (issub) {
                ans = s.substring(0, i + 1);
            } else
                return ans;
        }
        return ans;
    }
}