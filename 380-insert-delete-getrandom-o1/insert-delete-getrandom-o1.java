class RandomizedSet {

    private Random rand;
    private List<Integer> list;
    private Map<Integer,Integer> map;
    public RandomizedSet() 
    {
        rand = new Random();
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) 
    {
        if(map.containsKey(val))
        return false;

        list.add(val);
        map.put(val, list.size() - 1);

        return true;
    }
    
    public boolean remove(int val) 
    {
        if(!map.containsKey(val))
        return false;

        // get the index of the element
        int index = map.get(val);


        // replace the element at this index with the last element
        list.set(index, list.get(list.size() - 1));
        map.put(list.get(index), index);

        // remove the last element from the list and map
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }
    
    public int getRandom() 
    {
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */