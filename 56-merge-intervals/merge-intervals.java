class Solution {
    public int[][] merge(int[][] intervals) 
    {
        // Sort the intervals based on the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];
        mergedIntervals.add(currentInterval);

        for (int i = 1; i < intervals.length; i++) 
        {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // Merge intervals by updating the end time
            if(start <= currentInterval[1])
            currentInterval[1] = Math.max(currentInterval[1], end);

            else 
            {    // Add new interval and update reference
                currentInterval = new int[]{start, end};
                mergedIntervals.add(currentInterval);
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
