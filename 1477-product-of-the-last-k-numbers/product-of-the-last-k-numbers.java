class ProductOfNumbers {

    int lz;
    List<Integer> arr;

    public ProductOfNumbers() 
    {
        arr=new ArrayList<>();
        arr.add(1);
    }
    
    public void add(int num) 
    {
        int index= arr.size()-1;

        if(num==0)
        lz=index+1;

        if(arr.get(index)==0)
        arr.add(num);

        else
        arr.add(arr.get(index)*num);
    }
    
    public int getProduct(int k) 
    {
        int index= arr.size()-1;
        
        if(index-k<lz)
        return 0;

        if(arr.get(index-k)==0)
        return arr.get(index);

        return arr.get(index)/arr.get(index-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.push(num);
 * int param_2 = obj.getProduct(k);
 */