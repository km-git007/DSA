class Solution {

    private int LIS(int[] heights) 
    {
        int n = heights.length;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i = 0; i < n; i++)
        {
            int num = heights[i];
            Integer ceil = treeSet.ceiling(num);

            if(ceil != null)
            treeSet.remove(ceil);

            treeSet.add(num);
        }
        return treeSet.size();
    }

    public int maxEnvelopes(int[][] envelopes) 
    {
        Arrays.sort(envelopes, (a, b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });

        int index = 0;
        int[] heights = new int[envelopes.length];
        for(int[] envelope : envelopes)
        heights[index++] = envelope[1];

        return LIS(heights);
    }
}