class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k > nums.length) return new int[0];
        if (k ==  1) return nums;
        int i = k - 1;
        int max = nums[i - k + 1];
        int idx = 0;
        int[] ans = new int[nums.length - k + 1];
        ArrayList<Integer> list = new ArrayList<>();
        while (i < nums.length){
            for (int j = i - k + 1; j <= i; j++){
                if (max < nums[j]) max = nums[j];
            }
            ans[idx++] = max;
            i++;
            max = nums[i - k + 1];
        }
        return ans;
    }
}
