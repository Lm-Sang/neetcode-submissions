class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Boolean> map = new HashMap<>();
        int i = 1, j = 0, temp = 1, result = 0, start = 0;
        map.put(s.charAt(0), true);
        while (i < s.length()){
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), false);
            }
            if (map.get(s.charAt(i)) == true){
                i++;
                temp++;
            }
            else {
                j++;
                if (j == 1){
                    start = i;
                }
                if (j != k + 1) {
                    temp++;
                    i++;
                }
                if (j == k + 1) {
                    map.put(s.charAt(i - 1), false);
                    i = start;
                    j = 0;
                    map.put(s.charAt(i), true);
                    result = Math.max(temp, result);
                    temp = 1;
                }
            }
        }
        return Math.max(temp, result);
    }
}
