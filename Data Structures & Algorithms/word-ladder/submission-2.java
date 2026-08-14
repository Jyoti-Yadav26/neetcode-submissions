class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        HashSet<String> set = new HashSet<>();
        for (String s : wordList) {
            set.add(s);
        }
        if (!set.contains(endWord)) {
            return 0;
        }
        int steps = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int j = 0; j < size; j++) {
                String word = q.poll();

                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char original = arr[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        arr[i] = ch;
                        String s = String.valueOf(arr);

                        if (ch == original) {
                            continue;
                        }
                        if (s.equals(endWord)) {
                            return steps + 1;
                        }
                        if (set.contains(s)) {
                            q.offer(s);
                            set.remove(s);
                        }
                    }
                    arr[i] = original;
                }
            }
            steps++;
        }
        return 0;
    }
}