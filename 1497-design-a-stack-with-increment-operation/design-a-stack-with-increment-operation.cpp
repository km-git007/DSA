class CustomStack {
private:
    int MAX_CAPACITY;
    int top;
    int size;
    int* stack;
public:
    CustomStack(int maxSize) 
    {
        top=0;
        size=0;
        MAX_CAPACITY=maxSize;
        stack=new int[maxSize];
    }

    ~CustomStack() 
    {
        delete[] stack;
    }
    
    void push(int x) 
    {
        if(size>=MAX_CAPACITY)
        return;

        size++;
        stack[top++]=x;
    }
    
    int pop() 
    {
        if(size==0)
        return -1;

        size--;
        return stack[--top];
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