class Solution {
    public int halveArray(int[] nums) 
    {
        // Max Heap using PriorityQueue 
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());

        double Sum = 0;
        for(int num : nums)
        {
            Sum += num;
            pq.add((double)num);
        }

        double sum = Sum;
        int oper = 0;
        while(sum > Sum / 2)
        {
            double curr = pq.poll();
            sum -= curr / 2;

            pq.add(curr / 2);
            oper++;
        }
        return oper;
    }
}