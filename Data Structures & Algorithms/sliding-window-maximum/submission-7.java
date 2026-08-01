// Cách làm bằng DEQUEUE
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k > nums.length) return new int[0];
        if (k == 1) return nums;
        Deque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0, right = k;
        deque.offerLast(0);
        for (int i = 1; i < right; i++){
            while (!deque.isEmpty() &&
                nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        list.add(nums[deque.peekFirst()]);
        while(right < nums.length){
            while (!deque.isEmpty() &&
                nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }
            deque.offerLast(right);
            left++;
            while (!deque.isEmpty() && deque.peekFirst() < left) {
                deque.pollFirst();
            }
            list.add(nums[deque.peekFirst()]);
            right++;
        }
        int[] arr = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            arr[j] = list.get(j);
        }
        return arr;
    }

}
