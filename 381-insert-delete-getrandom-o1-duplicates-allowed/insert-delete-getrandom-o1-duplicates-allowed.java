class RandomizedCollection {
    private List<Integer> list;
    private Map<Integer, Set<Integer>> map;
    private Random rand;

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        boolean notPresent = !map.containsKey(val);
        map.putIfAbsent(val, new HashSet<>());
        map.get(val).add(list.size());
        list.add(val);
        return notPresent;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).isEmpty()) return false;

        int idxToRemove = map.get(val).iterator().next();  // get an index of val
        map.get(val).remove(idxToRemove);

        int lastIdx = list.size() - 1;
        int lastVal = list.get(lastIdx);

        // swap if not the last element
        if (idxToRemove != lastIdx) {
            list.set(idxToRemove, lastVal);
            map.get(lastVal).remove(lastIdx);
            map.get(lastVal).add(idxToRemove);
        }

        list.remove(lastIdx);

        if (map.get(val).isEmpty()) map.remove(val);

        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
