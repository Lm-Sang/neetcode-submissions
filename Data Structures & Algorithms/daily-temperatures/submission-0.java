class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> temp = new ArrayDeque<>();
        int[] arr = new int[temperatures.length];
        temp.offerLast(temperatures.length - 1);
        arr[temperatures.length - 1] = 0;
        for (int i = temperatures.length - 2; i >= 0; i--){
            while (!temp.isEmpty()
                && temperatures[temp.peek()] <= temperatures[i]) {
                temp.pop();
            }
            if (temp.isEmpty()){
                arr[i] = 0;
            }
            else {
                arr[i] = temp.peek() - i;
            }
            temp.push(i);
        }
        return arr; 
    }
}
