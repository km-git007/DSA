class CustomStack {
private:
    int MAX_CAPACITY;
    int top;
    int* stack;
public:
    CustomStack(int maxSize) 
    {
        top=0;
        MAX_CAPACITY=maxSize;
        stack=new int[maxSize];
    }

    ~CustomStack() 
    {
        delete[] stack;
    }
    
    void push(int x) 
    {
        if(top<MAX_CAPACITY)
        stack[top++]=x;
    }
    
    int pop() 
    {
        int topElement=-1;
        if(top>0)
        topElement=stack[--top];
        return topElement;
    }
    
    void increment(int k, int val) 
    {
        for(int i=0;i<min(k,MAX_CAPACITY);i++)
        stack[i]+=val;
    }
};

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack* obj = new CustomStack(maxSize);
 * obj->push(x);
 * int param_2 = obj->pop();
 * obj->increment(k,val);
 */