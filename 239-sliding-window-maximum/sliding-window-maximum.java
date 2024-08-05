class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        int n=nums.length;
        int[] res=new int[n-k+1];
        Deque<Integer> deque=new ArrayDeque<>();
		int i=0,index=0;
		for(int j=0;j<n;j++)
		{
			while(!deque.isEmpty() && nums[j]>deque.peekLast())
			deque.pollLast();
			deque.addLast(nums[j]);
			if(j-i+1==k)
			{
                res[index++]=deque.peekFirst();
				if(deque.peekFirst()==nums[i])
				deque.pollFirst();
				i++;
			}
		}
        return res;
    }
}