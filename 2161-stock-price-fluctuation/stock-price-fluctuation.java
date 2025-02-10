class StockPrice {

    private int currTime;
    private Map<Integer, Integer> timeMap; // {timestamp → price}
    private TreeMap<Integer, Integer> priceMap; // {price → frequency}
    public StockPrice() 
    {
        currTime = -1;
        timeMap = new HashMap<>();
        priceMap = new TreeMap<>();
    }

    public void update(int timestamp, int price) 
    {
        // Update latest timestamp
        currTime = Math.max(currTime, timestamp); 

        // If timestamp already exists, remove old price from priceMap
        if (timeMap.containsKey(timestamp)) 
        {
            int oldPrice = timeMap.get(timestamp);
            priceMap.put(oldPrice, priceMap.get(oldPrice) - 1);

            if(priceMap.get(oldPrice) == 0)
            priceMap.remove(oldPrice);
        }

        // Update maps
        timeMap.put(timestamp, price);
        priceMap.put(price, priceMap.getOrDefault(price, 0) + 1);
    }

    public int current() 
    {
        return timeMap.get(currTime);
    }

    public int maximum() 
    {
        return priceMap.lastKey(); 
    }

    public int minimum() 
    {
        return priceMap.firstKey(); 
    }
}

/**
 * Usage Example:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp, price);
 * int curr = obj.current();
 * int max = obj.maximum();
 * int min = obj.minimum();
 */
