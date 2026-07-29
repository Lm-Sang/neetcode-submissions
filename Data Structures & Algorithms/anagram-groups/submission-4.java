
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
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> maps = new HashMap<>();

        for (char cs : s.toCharArray()) {
            maps.put(cs, maps.getOrDefault(cs, 0) + 1);
        }

        Map<Character, Integer> mapt = new HashMap<>();

        for (char ct : t.toCharArray()) {
            mapt.put(ct, mapt.getOrDefault(ct, 0) + 1);
        }

        return maps.equals(mapt);
    }
}