class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int temp = 0;

        for (int i = 0; i < numbers.length; i++){
            temp = target - numbers[i];
            for (int j = numbers.length - 1; j >= i + 1; j--){
                if (temp == numbers[j]){
                    return new int[]{i+1, j+1};
                }
            }
        }
        return new int[]{0,0};
    }
}
