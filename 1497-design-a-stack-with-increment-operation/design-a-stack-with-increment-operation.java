class CustomStack {

    private int MAX_CAPACITY,index,lazyIndex;
    private int[] stack;
    private int[] increment;
    public CustomStack(int maxSize) 
    {
        stack=new int[maxSize];
        increment=new int[maxSize];
        MAX_CAPACITY=maxSize;
        index=0;
        lazyIndex = -1;     // Initialize lazyIndex to -1 (meaning no increment to apply)
    }
    
    public void push(int x) 
    {
        if(index<MAX_CAPACITY)
        stack[index++]=x;
    }
    
    public int pop() 
    {
        if(index==0)
        return -1;

        int actualIndex=index-1;
        if(lazyIndex<actualIndex)
        return stack[--index];

        int val=increment[lazyIndex];
        increment[lazyIndex]=0;
        if(lazyIndex>0)
        increment[lazyIndex-1]+=val;
        lazyIndex--;

        return stack[--index]+val;
    }
    
    public void increment(int k, int val) 
    {
        if(index>0) 
        {
            int limit = Math.min(k, index) - 1;  // Ensure we do not go out of bounds
            increment[limit] += val;  // Apply increment at the limit
            lazyIndex = Math.max(lazyIndex, limit);  // Adjust lazyIndex accordingly
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */