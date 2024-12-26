class TimeMap {


    public TimeMap() 
    {
        map = new HashMap<>();
    }

    private HashMap<String, TreeMap<Integer, String>> map;

    public void set(String key, String value, int timestamp) 
    {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) 
    {
        if (!map.containsKey(key)) 
        return "";

        Integer closestTimestamp = map.get(key).floorKey(timestamp);
        return closestTimestamp == null ? "" : map.get(key).get(closestTimestamp);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */