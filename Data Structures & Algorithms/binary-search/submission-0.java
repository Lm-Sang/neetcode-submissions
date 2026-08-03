class Solution {
    public int search(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) return -1;
        int i = nums.length / 2;
        if (target <= nums[i]){
            for (; i >= 0; i--){
                if (target > nums[i]) return -1;
                if (target == nums[i]) return i;
            }
        }
        else{
            for (; i < nums.length; i++){
                if (target < nums[i]) return -1;
                if (target == nums[i]) return i;
            }
        }
        return -1;
    }
}
