class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int k = left + (right - left) / 2;
            if (nums[k] > target){
                if (target < nums[right]){
                    left = k + 1;
                    continue;
                }
                right = k - 1;
            }
            // 345678912 789123456
            else if (nums[k] < target){
                if (target > nums[left]){
                    right = k - 1;
                }
                left = k + 1;
            }
            else return k;
        }

        return -1;
    }
}
