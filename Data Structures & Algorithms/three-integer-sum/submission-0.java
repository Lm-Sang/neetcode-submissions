class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> triple = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1){
                int target = 0 - entry.getKey() * 2;
                if (map.containsKey(target) && target != entry.getKey()){
                    triple = Arrays.asList(entry.getKey(), entry.getKey(), target);
                    Collections.sort(triple);   
                    if (set.add(triple)) {
    list.add(triple);
}
                }
                if (entry.getValue() >= 3 && entry.getKey() == 0){
                    list.add(Arrays.asList(0,0,0));
                }
            }
            int target = 0 - entry.getKey();
            for (int i = 0; i < nums.length; i++){
                int temp = target - nums[i];
                if (map1.containsKey(temp) && entry.getKey() != temp && temp != nums[i] && entry.getKey() != nums[i]){
                    triple = Arrays.asList(entry.getKey(), nums[i], temp);
                    Collections.sort(triple);   
                    if (set.add(triple)) {
    list.add(triple);
}
                }
                map1.put(nums[i],i);
            }
            map1.clear();

        }
            return list;


        
    }
}
