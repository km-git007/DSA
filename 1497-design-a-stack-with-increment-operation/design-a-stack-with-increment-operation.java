class CustomStack {

    private int capacity;
    private List<Integer> stack=new ArrayList<>();
    public CustomStack(int maxSize) 
    {
        capacity=maxSize;
    }
    
    public void push(int x) 
    {
        if(stack.size()<capacity)
        stack.add(x);
    }
    
    public int pop() 
    {
        int topElement=-1;
        if(stack.size()>0)
        {
            topElement=stack.get(stack.size()-1);
            stack.remove(stack.size()-1);
        }
        return topElement;
    }
    
    public void increment(int k, int val) 
    {
        int size=Math.min(k,stack.size());
        for(int i=0;i<size;i++)
        stack.set(i,stack.get(i)+val);
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */