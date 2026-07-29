class Solution {
    public boolean hasDuplicate(int[] nums) {
        int[] dup = new int [nums.length] ;
        for (int i = 0; i < nums.length; i++){
            for (int t = 0; t< dup.length; t++){
                if (nums[i] == dup[t]) return true;
            }
            dup[i] = nums[i];
        }
        return false;
    }
}