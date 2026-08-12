class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0, height, width;

        for (int i = 0; i <= heights.length; i++) {

            int currentHeight = (i == heights.length)
                    ? 0
                    : heights[i];

            while (!stack.isEmpty()
                    && currentHeight < heights[stack.peek()]) {
                height = heights[stack.pop()];
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
            if (i < heights.length) {
                stack.push(i);
            }
        }
        return maxArea;
    }
}