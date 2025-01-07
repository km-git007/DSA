class Solution {
    public int minKBitFlips(int[] nums, int k) 
    {
        Queue<Integer> q = new LinkedList<>();
        int flips = 0;
        for(int i = 0; i < nums.length; i++)
        {
            // Remove flips that are no longer within range
            if(!q.isEmpty() && q.peek() < i) 
            q.poll();
            
            if((nums[i] == 0 && q.size() % 2 == 0) || (nums[i] == 1 && q.size() % 2 == 1))
            {
                if(i + k - 1 >= nums.length)
                return -1;

                q.add(i + k - 1);
                flips++;
            }
        }
        return flips;
    }
}