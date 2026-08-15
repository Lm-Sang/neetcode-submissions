class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int k = left + (right - left) / 2;
            if (nums[k] == target) {
                return k;
            }
            if (nums[left] <= nums[k]) {
                if (nums[left] <= target && target < nums[k]) {
                    right = k - 1;
                } 
                else {
                    left = k + 1;
                }

            } 
            else {
                if (nums[k] < target && target <= nums[right]) {
                    left = k + 1;
                } 
                else {
                    right = k - 1;
                }
            }
        }
        return -1;
    }
}