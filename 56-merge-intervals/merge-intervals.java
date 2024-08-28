class Solution {
    public int[][] merge(int[][] intervals) 
    {
        // Sort the intervals based on the first element of each sub-array
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] prev=new int[]{intervals[0][0],intervals[0][1]};
        List<int[]> ans=new ArrayList<>();
        ans.add(prev);
        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i][0]<=prev[1])
            prev[1]=Math.max(prev[1],intervals[i][1]);
            else
            {
                prev=new int[]{intervals[i][0], intervals[i][1]};
                ans.add(prev);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}