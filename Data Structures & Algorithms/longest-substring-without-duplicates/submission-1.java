class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int temp = 0;
        for (int i = 0; i < s.length(); i++){
            if (set.contains(s.charAt(i))) {
                temp = Math.max(temp, set.size());
                set.clear();
            }
            set.add(s.charAt(i));
        }
        if (s.length() <= 1) return set.size();
        return temp;
    }
}
