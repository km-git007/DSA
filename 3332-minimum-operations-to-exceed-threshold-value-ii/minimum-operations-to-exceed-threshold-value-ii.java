class Solution {
    public int minOperations(int[] nums, int k) 
    {
        // Creating a Min Heap
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(int num : nums)
        pq.add(Long.valueOf(num)); 

        int oper = 0;
        while(pq.size() > 1)
        {
            long a = pq.poll();
            long b = pq.poll();

            if(a >= k && b >= k)
            break;

            long c = a * 2 + b;
            pq.add(c);

            oper++;
        }

        return oper;
    }
}