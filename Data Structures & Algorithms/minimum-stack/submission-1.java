class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.offerLast(val);
        if (minStack.isEmpty() || minStack.peekLast() > val){
            minStack.offerLast(val);
        }
        else{
            minStack.offerLast(minStack.peekLast());
        }
    }

    public void pop() {
        if (stack.peekLast() == minStack.peekLast()){
            minStack.pollLast();
        }
        stack.pollLast();
    }

    public int top() {
        return stack.peekLast();
    }

    public int getMin() {   
        return minStack.peekLast();
    }
}