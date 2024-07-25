class Solution {

    public int leastInterval(char[] tasks, int coolingTime) 
    {
        int n=tasks.length;
        int []frequencyMap=new int[26];
        for(char c : tasks)
        frequencyMap[c-'A']++;

        // Compare based on the frequency.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        for(int i=0;i<26;i++)
        {
            int frequency=frequencyMap[i];
            if(frequency>0)
            maxHeap.add(frequency);
        }

        int time=0;
        while(!maxHeap.isEmpty())
        {
            int cycleTime=coolingTime+1;
            int currTime=0;
            List<Integer> coolingList=new ArrayList<>();
            while(currTime<cycleTime)
            {
                if(!maxHeap.isEmpty())
                {
                    int freq=(int)maxHeap.poll();
                    freq--;
                    if(freq>0)
                    coolingList.add(freq);
                }
                currTime++;
                if(maxHeap.isEmpty() && coolingList.isEmpty())
                break;
            }
            time+=currTime;
            for(int f : coolingList)
            maxHeap.add(f);
        }
        return time;
    }
}