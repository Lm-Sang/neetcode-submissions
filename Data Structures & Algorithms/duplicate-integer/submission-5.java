class Solution {
    public boolean hasDuplicate(int[] nums) {
        float[] dup = new float [nums.length] ;
        for (int i = 0; i < nums.length; i++){
            for (int t = 0; t< i; t++){
                if (nums[i] == dup[t]) return true;
            }
            dup[i] = nums[i];
        }
        return false;
    }
}