class CustomStack {

    private int capacity,index;
    private int[] stack;
    public CustomStack(int maxSize) 
    {
        stack=new int[maxSize];
        capacity=maxSize;
        index=0;
    }
    
    public void push(int x) 
    {
        if(index<capacity)
        stack[index++]=x;
    }
    
    public int pop() 
    {
        int topElement=-1;
        if(index>0)
        topElement=stack[--index];
        return topElement;
    }
    
    public void increment(int k, int val) 
    {
        int size=Math.min(k,index);
        for(int i=0;i<size;i++)
        stack[i]+=val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */