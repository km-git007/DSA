class Node {
    int timestamp;
    String value;
    public Node(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}

class TimeMap {
    private HashMap<String, List<Node>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) 
    {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Node(timestamp, value));
    }

    public String binarySearch(String key, int timestamp)
    {
        List<Node> nodes = map.get(key);
        int left = 0, right = nodes.size() - 1;
        String result = "";
        // Binary search for the closest timestamp <= given timestamp
        while (left <= right) 
        {
            int mid = left + (right - left) / 2;
            if (nodes.get(mid).timestamp == timestamp) {
                return nodes.get(mid).value;
            } else if (nodes.get(mid).timestamp < timestamp) {
                result = nodes.get(mid).value;  // candidate answer
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public String get(String key, int timestamp) 
    {
        if (!map.containsKey(key)) 
        return "";

        return binarySearch(key, timestamp);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */