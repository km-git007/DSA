class Solution {
    public int totalFruit(int[] fruits) 
    {
        int maxi = 0, i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int j = 0; j < fruits.length; j++)
        {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            if(map.size() > 2)
            {
                // remove 1 quantity the ith fruit from the basket
                map.put(fruits[i], map.get(fruits[i]) - 1);

                // if no more quantity of the its fruit is left than remove it from the map
                if(map.get(fruits[i]) == 0)
                map.remove(fruits[i]);

                i++;
            }

            if(map.size() <= 2)
            maxi = Math.max(maxi, j - i + 1);
        }
        return maxi;
    }
}