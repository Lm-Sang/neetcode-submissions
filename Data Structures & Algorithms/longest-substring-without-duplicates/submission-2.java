class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int temp = 0;
        for (int i = 0; i < s.length(); i++){
            if (set.contains(s.charAt(i))) {
                set.clear();
            }
            set.add(s.charAt(i));
            temp = Math.max(temp, set.size());
        }
        return temp;
    }
}
