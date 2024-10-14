class Solution {
    public long maxKelements(int[] nums, int k) 
    {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums) 
        maxHeap.add(num);
        
        long score = 0;
        while(k>0)
        {
            int maxElement = maxHeap.poll();
            score += maxElement;
            maxElement = Math.ceilDiv(maxElement, 3);
            maxHeap.add(maxElement);
            k--;
        }
        return score;
    }
}