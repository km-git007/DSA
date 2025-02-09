class NumberContainers {

    Map<Integer, TreeSet<Integer>> numMap;
    Map<Integer, Integer> indexMap;
    public NumberContainers() 
    {
        numMap = new HashMap<>();
        indexMap = new HashMap<>();
    }

    public void change(int index, int number) 
    {
        // if the number is already present at the index
        if(indexMap.containsKey(index))
        {
            int oldNumber = indexMap.get(index);

            // remove the index from the oldNumbers treeSet
            TreeSet set = numMap.get(oldNumber);
            set.remove(index);

            if(set.isEmpty())
            numMap.remove(oldNumber);
        }
        
        indexMap.put(index, number);

        // insert the number in the numMap
        numMap.putIfAbsent(number, new TreeSet<>());
        numMap.get(number).add(index);
    }
    
    public int find(int number) 
    {
        if(!numMap.containsKey(number))
        return -1;

        return numMap.get(number).first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */