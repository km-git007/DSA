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
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : tasks)
        map.put(c,map.getOrDefault(c,0) + 1);

        // Compare based on the frequency.
        PriorityQueue<Task> maxHeap = new PriorityQueue<>((a,b) -> b.freq-a.freq);

        for (Character key : map.keySet())
        {
            Task t=new Task(key,map.get(key));
            maxHeap.add(t);
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