class Solution {

    Random random;
    int[] prefixSum;
    public Solution(int[] w) 
    {
        random = new Random();
        prefixSum = new int[w.length];
        int pSum = 0;
        for(int i = 0; i < w.length; i++)
        {
            pSum += w[i];
            prefixSum[i] = pSum;
        }
    }
    
    public int pickIndex() 
    {
        int n = prefixSum.length;

        // pick a random number int the range [1, sum]
        int target = random.nextInt(prefixSum[n - 1]) + 1;

        // now we have to search that in which bucket this number will fall
        int start = 0, end = n -1;
        while(start <= end)
        {
            int mid = start + (end - start)/2;

            if(prefixSum[mid] < target)
            start = mid + 1;

            else
            end = mid - 1;
        }
        return start;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */