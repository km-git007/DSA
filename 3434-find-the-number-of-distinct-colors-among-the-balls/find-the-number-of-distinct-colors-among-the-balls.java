class Solution {

    public int[] queryResults(int limit, int[][] queries) 
    {
        // indexMap --> {index, color} --> stores the color at a given index
        // colorMap --> {color, frequency} --> maps the color with its frequency
        Map<Integer, Integer> indexMap = new HashMap<>();
        Map<Integer, Integer> colorMap = new HashMap<>();

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) 
        {
            int index = queries[i][0];
            int color = queries[i][1];

            // if a ball is present at the index already
            if (indexMap.containsKey(index)) 
            {
                // fetch the color of the ball already present at the index
                int ballColor = indexMap.get(index);

                // decrease the count of this color in the color map
                colorMap.put(ballColor, colorMap.get(ballColor) - 1);

                // remove this ball from the colorMap if count becomes '0'
                if(colorMap.get(ballColor) == 0) 
                colorMap.remove(ballColor);
            }

            // map the color to the index
            indexMap.put(index, color);
            // increase the frequency of the color in the colorMap
            colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);

            // push the number of distinct color balls in the res
            // i.e., push the size of the colorMap
            res[i] = colorMap.size();
        }
        
        return res;
    }
}
