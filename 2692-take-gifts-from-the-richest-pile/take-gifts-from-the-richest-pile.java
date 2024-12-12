class Solution {
    public long pickGifts(int[] gifts, int k) 
    {
        // Create a PriorityQueue of int[] 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for(int i = 0; i < gifts.length; i++)
        pq.add(new int[]{gifts[i], i});

        while(k > 0)
        {
            var ele = pq.poll();
            int num = ele[0];
            int index = ele[1];
            // calculate squareRoot
            int rootOfNumber = (int)Math.sqrt(num);

            // put the new number back in the array
            gifts[index] = rootOfNumber;

            // push in the queue
            pq.add(new int[]{rootOfNumber, index});
            k--;
        }

        long sum = 0;
        for(int i = 0; i < gifts.length; i++)
        sum += gifts[i];
        
        return sum;
    }
}