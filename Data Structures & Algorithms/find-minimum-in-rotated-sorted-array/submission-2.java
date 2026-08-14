class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int k = left + (right - left) / 2;
            if (nums[k] <= nums[k + 1] && nums[k] <= nums[k - 1]){
                return nums[k];
            }
            else {
                if (nums[left] > nums[right]) left = k + 1;
                else right = k - 1;
            }
        }
        return 0;
    }
}
