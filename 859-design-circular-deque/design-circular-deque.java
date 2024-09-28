class MyCircularDeque {

    private int[] deque;
    private int size;
    private final int MAX_CAPACITY;
    private int front,rear; 
    public MyCircularDeque(int k) 
    {
        size=0;
        MAX_CAPACITY=k;
        front=0;
        rear=k-1;
        deque=new int[k];
    }
    
    public boolean insertFront(int value) 
    {
        if(isFull())
        return false;

        front=(front-1+MAX_CAPACITY)%MAX_CAPACITY;
        deque[front]=value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) 
    {
        if(isFull())
        return false;

        rear=(rear+1)%MAX_CAPACITY;
        deque[rear]=value;
        size++;
        return true;
    }
    
    public boolean deleteFront() 
    {
        if(isEmpty())
        return false;

        front=(front+1)%MAX_CAPACITY;
        size--;
        return true;
    }
    
    public boolean deleteLast() 
    {
        if(isEmpty())
        return false;

        rear=(rear-1+MAX_CAPACITY)%MAX_CAPACITY;
        size--;
        return true;
    }
    
    public int getFront() 
    {
        if(size==0)
        return -1;

        return deque[front];
    }
    
    public int getRear() 
    {
        if(size==0)
        return -1;
        
        return deque[rear];
    }
    
    public boolean isEmpty() 
    {
        return size==0;
    }
    
    public boolean isFull() 
    {
        return size==MAX_CAPACITY;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */