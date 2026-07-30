class Solution {
    public int trap(int[] height) {
        int result = 0, maxLeft, maxRight, left = 0;
        int right = height.length - 1;
        maxRight = height[right];
        maxLeft = height[left];
        while (left < right){
            if (maxLeft <= maxRight){
                result += maxLeft - height[left];
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
            }
            else{
                result += maxRight - height[right];
                right--;
                maxRight = Math.max(maxRight, height[right]);
            }
        }
        return result;
    }
}
