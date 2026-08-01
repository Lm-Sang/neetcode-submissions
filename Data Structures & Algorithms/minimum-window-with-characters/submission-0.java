class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, required = need.size(), formed = 0;
        int bestLen = Integer.MAX_VALUE, bestLeft = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                formed++;
            }

            // Thu hẹp từ bên trái khi cửa sổ vẫn còn hợp lệ
            while (formed == required) {
                if (right - left + 1 < bestLen) {
                    bestLen = right - left + 1;
                    bestLeft = left;
                }
                char lc = s.charAt(left);
                window.put(lc, window.get(lc) - 1);
                if (need.containsKey(lc) && window.get(lc) < need.get(lc)) {
                    formed--;
                }
                left++;
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestLeft, bestLeft + bestLen);
    }
}