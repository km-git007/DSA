class DinnerPlates {

    private final int CAPACITY;
    private final List<Deque<Integer>> stackList;
    private final TreeSet<Integer> availableStack;

    public DinnerPlates(int capacity) {
        this.CAPACITY = capacity;
        stackList = new ArrayList<>();
        availableStack = new TreeSet<>();
    }


    public void push(int val) {
        if(availableStack.isEmpty()) {
            stackList.add(new ArrayDeque<>());
            availableStack.add(stackList.size() - 1);
        }

        // Gets the smallest value from the treeSet which will be the index
        // of the first stack with space to push a value
        Deque<Integer> leftmostStack = stackList.get(availableStack.first());
        leftmostStack.push(val);

        // If this leftmostStack reaches max capacity, remove the index from treemap
        if(leftmostStack.size() == CAPACITY) {
            availableStack.pollFirst();
        }
    }

    public int pop() {
        if(stackList.isEmpty()) {
            return -1;
        }

        int val = stackList.getLast().pop(); // Pop from the last stack in the list of stacks

        // Since we removed at least 1 element from this last stack, let's add its index to availableStack
        availableStack.add(stackList.size() - 1);

        // Once we remove an element from the last stack, we need to check if that stack is empty or not,
        // and if empty, we need to remove the empty stacks
        while (!stackList.isEmpty() && stackList.getLast().isEmpty()) {
            stackList.removeLast(); // Remove the stack from the list of stacks

            // Since we removed the element from the last index, and that was in availableStack
            // as a stack which has space to push more elements, it would have been the highest
            // value in the TreeSet, since data stays as sorted in TreeSet. So we can use pollLast()
            // to remove the last (or rather the highest value) index now, since we also removed that
            // empty stack from the list of stacks
            availableStack.pollLast();
        }
        return val;
    }

    public int popAtStack(int index) {
        if (index >= stackList.size()) {
            return -1; // Invalid stack index
        }

        // Basically the last stack
        if (index == stackList.size() - 1) {
            return pop();
        }

        // If it's any index other than the last stack, then...
        Deque<Integer> stack = stackList.get(index);
        int val = stack.isEmpty() ? -1 : stack.pop();

        // Since we removed an element, it frees up a space in that stack
        availableStack.add(index);

        return val;
    }
}
