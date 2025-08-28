class RandomizedSet {

    private Map<Integer, Integer> numMap;
    private List<Integer> numList;
    private Random rand;
    public RandomizedSet() {
        numMap = new HashMap();
        numList = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if(numMap.containsKey(val)) return false;
        numList.add(val);
        numMap.put(val, numList.size() - 1);
        return true;
    }
    
    
    public boolean remove(int val) {
        if(!numMap.containsKey(val)) return false;
        // get index of the element to be removed
        int index = numMap.get(val);
        int lastElement = numList.getLast();
        // swap the element with the last element
        numList.set(index, lastElement);
        // update in map
        numMap.put(lastElement, index);
        
        // remove the element supposed to be removed from the map and list
        numMap.remove(val);
        numList.removeLast();
        return true;
    }

    public int getRandom() {
        int index = rand.nextInt(numList.size());
        return numList.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */