class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < s.length()) {
            // Find '#'
            int j = i;

            while (s.charAt(j) != '#') {
                j++;
            }

            // Get length
            int len = Integer.parseInt(s.substring(i, j));

            // Start of actual string
            int start = j + 1;

            // Extract exactly len characters
            String str = s.substring(start, start + len);

            result.add(str);

            // Move to next encoded string
            i = start + len;
        }

        return result;
    }
}
