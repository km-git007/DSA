class Node{
    int day;
    int price;

    public Node(int day, int price) {
        this.day = day;
        this.price = price;
    }
}
class StockSpanner {

    private Deque<Node> stack;
    int index = 1;
    public StockSpanner() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        while(!stack.isEmpty() && stack.peek().price <= price) {
            stack.pop();
        }
        
        int span;
        if(stack.isEmpty()) span = index;
        else span = index - stack.peek().day;
        
        stack.push(new Node(index, price));
        index++;
        
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */