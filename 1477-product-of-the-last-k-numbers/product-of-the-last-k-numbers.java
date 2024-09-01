class ProductOfNumbers {

    int lastZeroIndex;
    List<Integer> list;
    public ProductOfNumbers() 
    {
        list=new ArrayList<>();
        list.add(1);
        lastZeroIndex=-1;
    }
    
    public void add(int num) 
    {
        int index= list.size()-1;

        if(num==0)
        lastZeroIndex=index+1;

        if(list.get(index)==0)
        list.add(num);

        else
        list.add(list.get(index)*num);
    }
    
    public int getProduct(int k) 
    {
        int index= list.size()-1;
        
        if(index-k<lastZeroIndex)
        return 0;

        if(list.get(index-k)==0)
        return list.get(index);

        return list.get(index)/list.get(index-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.push(num);
 * int param_2 = obj.getProduct(k);
 */