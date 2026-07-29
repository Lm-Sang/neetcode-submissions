
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Boolean> map = new HashMap<>();
        Map<String, List<String>> result = new HashMap<>();

        for (String s : strs) {
            map.put(s, false);
        }

        List<Map.Entry<String, Boolean>> entries = new ArrayList<>(map.entrySet());

        for (int i = 0; i < entries.size(); i++) {
            if (entries.get(i).getValue()) {
                continue;
            }

            String key = entries.get(i).getKey();

            result.put(key, new ArrayList<>());
            result.get(key).add(key);

            for (int j = i + 1; j < entries.size(); j++) {
                if (entries.get(j).getValue()) {
                    continue;
                }

                if (isAnagram(key, entries.get(j).getKey())) {
                    result.get(key).add(entries.get(j).getKey());

                    map.put(entries.get(j).getKey(), true);
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