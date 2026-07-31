class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int i = 0;
        HashMap<Character, Integer> set1 = new HashMap<>();
        HashMap<Character, Integer> set2 = new HashMap<>();
        if (s1.length() > s2.length()) return false;
        for (int j = 0; j < s2.length(); j++){
            if (j < s1.length()){
                set2.put(s2.charAt(j), set2.getOrDefault(s2.charAt(j), 0) + 1);
                set1.put(s1.charAt(j), set1.getOrDefault(s1.charAt(j), 0) + 1);
            }
            else {
                if (set1.equals(set2)) return true;
                else {
                    if(set2.get(s2.charAt(i)) > 1){
                        set2.put(s2.charAt(i), set2.get(s2.charAt(i)) - 1);
                    }
                    else {
                        set2.remove(s2.charAt(i));
                    }
                    set2.put(s2.charAt(j), set2.getOrDefault(s2.charAt(j), 0) + 1);
                    i++;
                }
            }
        }
        return set1.equals(set2);
    }
}
