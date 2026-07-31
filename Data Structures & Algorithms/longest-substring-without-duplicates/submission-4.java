class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int temp = 0, result = 0;
        for (int i = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                temp = map.get(s.charAt(i)) + 1;
            }
            result = Math.max(result, i - temp + 1);
            map.put(s.charAt(i), i);
        }
        return result;
    }
}
