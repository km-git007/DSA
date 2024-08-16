class OrderedStream {

    private String[] map;
    private int index,size;
    private List<String> concatenate()
    {
        List<String> ans=new ArrayList<>();
        for(int i=index;i<size;i++)
        {
            if(map[i]==null)
            break;
            ans.add(map[i]);
            index++;
        }
        return ans;
    }

    public OrderedStream(int n) 
    {
        map=new String[n];
        size=n;
        index=0;
    }
    
    public List<String> insert(int idKey, String value) 
    {
        map[idKey-1]=value;

        if(index!=idKey-1)
        return new ArrayList<String>();

        return concatenate();
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */