class Solution {

    public int[] getFinalState(int[] nums, int k, int multiplier) 
    {
        PriorityQueue<int[]> minHeap=new PriorityQueue<>( (a,b)-> {
                if(a[0]-b[0]==0)
                return a[1]-b[1];
                return a[0]-b[0];
        });
        
        for(int i=0;i<nums.length;i++)
        minHeap.add(new int[]{nums[i],i});

        while(k>0)
        {
            int num=minHeap.peek()[0]*multiplier;
            int index=minHeap.poll()[1];

            nums[index]=num;
            minHeap.add(new int[]{num,index});
            k--;
        }
        return nums;
    }
}