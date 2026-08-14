class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int k = left + (right - left) / 2;

            if (nums[k] > nums[left] && nums[k] > nums[right]) {
                if (nums[left] < nums[right]) right = k;
                else left = k;  
            } 
            if (nums[k] < nums[left] && nums[k] < nums[right]){
                return nums[k];
            }
        }
        return 0;
    }
}
