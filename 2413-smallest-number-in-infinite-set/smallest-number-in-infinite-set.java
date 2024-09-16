class SmallestInfiniteSet {

    int[] arr;
    public SmallestInfiniteSet() 
    {
        arr=new int [1001]; 
    }
    
    public int popSmallest() 
    {
        for(int i=1;i<=1001;i++)
        if(arr[i]==0)
        {
            arr[i]=1;
            return i;
        }
        return -1;
    }
    
    public void addBack(int num) 
    {
        if(arr[num]==1)
        {
            arr[num]=0;
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */