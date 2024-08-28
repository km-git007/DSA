class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) 
    {
        int n=intervals.length;
        if(n==0)
        return new int[][]{newInterval};

        int i=0;
        List<int[]> ans=new ArrayList<>();
        // non-overlapping left part
        while(i<n && intervals[i][1]<newInterval[0])
        {
            ans.add(intervals[i]);
            i++;
        }

        // overlapping part
        while(i<n && intervals[i][0]<=newInterval[1])
        {
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        ans.add(newInterval);

        while(i<n)
        {
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}