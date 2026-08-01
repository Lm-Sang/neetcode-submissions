// Cách làm bằng HEAP
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k > nums.length) return new int[0];
        if (k == 1) return nums;
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Node> heap =
            new PriorityQueue<>(
                (a, b) -> b.value - a.value
            );
        int right = k - 1;
        int left = 0;
        for (int i = 0; i < right; i++){
            heap.offer(new Node(nums[i], i));
        }
        while (right < nums.length){
            heap.offer(new Node(nums[right], right));
            if(heap.peek().index < left) heap.poll();
            list.add(heap.peek().value);
            left++;
            right++;
        }
        int[] arr = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            arr[j] = list.get(j);
        }
        return arr;
    }

    class Node {
        int value;
        int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
