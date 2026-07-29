class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (map.containsKey(entry.getKey() + 1)){
                int max = Math.max(
    map.get(entry.getKey()),
    map.get(entry.getKey() + 1)
);

map.put(entry.getKey(), max + 1);
map.put(entry.getKey() + 1, max + 1);
            }
        }
        Map.Entry<Integer, Integer> maxEntry = null;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
        return maxEntry.getValue();
    }
}
