class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k > nums.length) return new int[0];
        int i = k - 1;
        int max = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (i < nums.length){
            for (int j = i - k + 1; j <= i; j++){
                if (max < nums[j]) max = nums[j];
            }
            list.add(max);
            max = 0;
            i++;
        }
        int[] arr = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            arr[j] = list.get(j);
        }
        return arr;
    }
}
