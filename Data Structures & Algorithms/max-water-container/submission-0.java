class Solution {
    public int maxArea(int[] heights) {
        int max = 0; 
        for (int i = 0; i <= heights.length; i++){
            for (int j = heights.length - 1; j > i + 1; j--){
                int temp = Math.min(heights[i], heights[j]) * (j - i);
                if (max < temp) max = temp;
            }
        }
        return max;
    }
}
