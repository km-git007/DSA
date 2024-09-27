class Solution {
    public int[] resultsArray(int[][] queries, int k) 
    {
        int index=0;
        int[] ans=new int[queries.length];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int[] query : queries)
        {
            maxHeap.add(Math.abs(query[0])+Math.abs(query[1]));
            if(maxHeap.size()>k)
            maxHeap.poll();

            ans[index++]=(maxHeap.size()==k)?maxHeap.peek():-1;
        }
        return ans;
    }
}