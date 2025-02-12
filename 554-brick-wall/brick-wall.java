class Solution {
    public int leastBricks(List<List<Integer>> wall) 
    {
        // {pos, count of Brick Edges}
        Map<Integer, Integer> map = new HashMap<>();
        int maxEdges = 0;
        for (List<Integer> row : wall) 
        {
            int pos = 0;
            // Exclude the last brick in each row
            for (int i = 0; i < row.size() - 1; i++) 
            {
                pos += row.get(i);
                map.put(pos, map.getOrDefault(pos, 0) + 1);
                maxEdges = Math.max(maxEdges, map.get(pos));
            }
        }
        return wall.size() - maxEdges;
    }
}