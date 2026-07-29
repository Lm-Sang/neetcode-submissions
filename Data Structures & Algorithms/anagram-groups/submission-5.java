
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        boolean[] visited = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++){
            visited[i] = false;
        }
        for (int i = 0; i < strs.length; i++) {
            if (visited[i]) {
                continue;
            }
            String key = strs[i];

            result.put(key, new ArrayList<>());
            result.get(key).add(key);

            for (int j = i + 1; j < strs.length; j++) {
                if (visited[j]) {
                    continue;
                }

                if (isAnagram(key, strs[j])) {
                    result.get(key).add(strs[j]);
                    visited[j] = true;
                }
            }
        }

        return new ArrayList<>(result.values());
    }

    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];

        for (char c : s.toCharArray())
            count[c - 'a']++;

        for (char c : t.toCharArray())
            count[c - 'a']--;

        for (int x : count)
            if (x != 0)
                return false;

        return true;
    }
}