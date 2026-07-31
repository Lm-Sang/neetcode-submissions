class Solution {
    public int maxProfit(int[] prices) {
        int result = 0, min = prices[0];

        for (int i = 1; i < prices.length; i++){
            if (min > prices[i]){
                min = prices[i];
                continue;
            }
            if (result < prices[i] - min) result = prices[i] - min;
        }
        return result;
    }
}
