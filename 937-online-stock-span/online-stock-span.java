class StockSpanner {

    private ArrayDeque<int[]> stack = new ArrayDeque<>();
    int index=0;
    public StockSpanner() {}

    public int next(int price) 
    {
        int span=1;
        while(!stack.isEmpty() && stack.peek()[0]<=price)
        stack.pop();

        if(stack.isEmpty())
        span=index+1;
        else
        span=index-stack.peek()[1];

        stack.push(new int[]{price,index});
        index++;
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */