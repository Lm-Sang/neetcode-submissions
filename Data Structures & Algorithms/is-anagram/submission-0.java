class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> maps = new HashMap<>();

        for (char cs : s.toCharArray()){
            maps.put(cs, maps.getOrDefault(cs, 0) + 1);
        }

        Map<Character, Integer> mapt = new HashMap<>();

        for (char ct : t.toCharArray()){
            mapt.put(ct, mapt.getOrDefault(ct, 0) + 1);
        }

        if (maps.equals(mapt)) return true;
        return false;
    }
}
