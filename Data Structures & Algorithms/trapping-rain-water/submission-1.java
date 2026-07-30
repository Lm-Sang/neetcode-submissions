class Solution {
    public int trap(int[] height) {
        int result = 0, maxLeft = 0, maxRight = 0, left = 0;
        int right = height.length - 1;
        while (left < right){
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            if (maxLeft <= maxRight){
                result += maxLeft - height[left];
                left++;
            }
            else{
                result += maxRight - height[right];
                right--;
            }
        }
        return result;
    }
}
