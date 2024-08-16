class MyHashSet {

    boolean[] dp=new boolean[1000001];
    public MyHashSet(){}
    
    public void add(int key) 
    {
        dp[key]=true;
    }
    
    public void remove(int key) 
    {
        dp[key]=false;
    }
    
    public boolean contains(int key) 
    {
        return dp[key]==true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */