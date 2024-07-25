class Solution {

    class Task
    {
        int index;
        int processingTime;
        int startTime;
        Task(int startTime,int processingTime,int index)
        {
            this.processingTime=processingTime;
            this.startTime=startTime;
            this.index=index;
        }
    }

    public int[] getOrder(int[][] tasks) 
    {   
        int n=tasks.length;
        Task [] tasksList=new Task[n];

        for(int i=0;i<n;i++)
        tasksList[i]=new Task(tasks[i][0],tasks[i][1],i);

        Arrays.sort(tasksList,
            (a,b)-> {
                // Compare based on start time
                return a.startTime-b.startTime;
                // // Compare based on processing time if start time is same
                // return a.processingTime-b.processingTime;
            }
        );

        PriorityQueue<Task> minHeap = new PriorityQueue<>(
            (a,b) -> {
                // Compare based on the processing time
                if(a.processingTime!=b.processingTime)
                return a.processingTime-b.processingTime;
                // Compare based on the index if processing time is same
                return a.index-b.index;
            }
        );

        int []order=new int[n];
        int i=0,j=0;
        int time=0;
        while(i<n || !minHeap.isEmpty())
        {
            if(minHeap.isEmpty() && time<tasksList[i].startTime)
            time=tasksList[i].startTime;

            while(i<n && tasksList[i].startTime<=time)
            {
                minHeap.add(tasksList[i]);
                i++;
            }

            Task t=minHeap.poll();
            order[j++]=t.index;
            time+=t.processingTime;
        }
        return order;
    }
}