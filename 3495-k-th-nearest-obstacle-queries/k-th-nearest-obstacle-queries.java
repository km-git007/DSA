class Solution {
    public int[] resultsArray(int[][] queries, int k) 
    {
        int[] ans=new int[queries.length];
        for(int i=0;i<Math.min(k-1,queries.length);i++)
        ans[i]=-1;

        int index=k-1;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int[] query : queries)
        {
            maxHeap.add(Math.abs(query[0])+Math.abs(query[1]));
            if(maxHeap.size()>k)
            maxHeap.poll();

            if(maxHeap.size()==k)
            ans[index++]=maxHeap.peek();
        }
        return ans;
    }
}