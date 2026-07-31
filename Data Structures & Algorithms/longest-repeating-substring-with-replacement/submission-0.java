class Solution {
    public int characterReplacement(String s, int k) {
        HashSet<Character> set = new HashSet<>();
        int i = 1, j = 0, temp = 0, result = 0, start = 0;
        set.add(s.charAt(0));
        while (i < s.length()){
            if (set.contains(s.charAt(i))){
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
                }
                if (j == k + 1) {
                    i = start;
                    j = 0;
                    set.add(s.charAt(i));
                    result = Math.max(temp + 1, result);
                    temp = 1;
                }
            }
        }
        return Math.max(temp, result);
    }
}
