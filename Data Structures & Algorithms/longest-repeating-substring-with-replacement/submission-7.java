class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, temp = 0, window = 0, result = 0;
        for (int j = 0; j < s.length(); j++){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0) + 1);
            temp = maxFreq(map);
            window += 1;
            if (window - temp > k){
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
                window--;
                continue;
            }
            result = Math.max(result, window);
        }
        return result;
    }

    public int maxFreq(HashMap<Character, Integer> map){
        int axFreq = 0;
        for (int value : map.values()) {
            axFreq = Math.max(axFreq, value);
        }
        return axFreq;
    }


}
