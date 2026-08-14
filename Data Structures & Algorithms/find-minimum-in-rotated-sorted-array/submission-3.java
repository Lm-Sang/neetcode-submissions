class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int k = left + (right - left) / 2;
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            if (nums[k] < nums[left]) {
                right = k;
            }
            else {
                left = k + 1;
            }
        }

        return nums[left];
    }
}