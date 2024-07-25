class Solution {

    class Task
    {
        char id;
        int freq;
        Task(char id,int freq)
        {
            this.freq=freq;
            this.id=id;
        }
    }

    public int leastInterval(char[] tasks, int coolingTime) 
    {
        int n=tasks.length;
        int []frequencyMap=new int[26];
        for(char c : tasks)
        frequencyMap[c-'A']++;

        // Compare based on the frequency.
        PriorityQueue<Task> maxHeap = new PriorityQueue<>((a,b) -> b.freq-a.freq);

        for(int i=0;i<26;i++)
        {
            int frequency=frequencyMap[i];
            if(frequency>0)
            maxHeap.add(new Task((char)('A'+i),frequency));
        }

        int time=0;
        while(!maxHeap.isEmpty())
        {
            int cycleTime=coolingTime+1;
            int currTime=0;
            List<Task> tasksList=new ArrayList<>();
            while(currTime<cycleTime)
            {
                if(!maxHeap.isEmpty())
                {
                    Task t=maxHeap.poll();
                    t.freq--;
                    if(t.freq>0)
                    tasksList.add(t);
                    System.out.print(t.id + " ");
                }
                currTime++;
                if(maxHeap.isEmpty() && tasksList.isEmpty())
                break;
            }
            time+=currTime;
            for(Task task : tasksList)
            maxHeap.add(task);
        }
        return time;
    }
}