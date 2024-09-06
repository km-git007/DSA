class Solution {
    public long taskSchedulerII(int[] tasks, int space) 
    {
        long time=0;
        HashMap<Integer,Long> map=new HashMap<>();
        for(int task : tasks)
        {
            if(map.containsKey(task))
            time=Math.max(map.get(task)+space,time);
            // Complete the current task
            time++;
            // Map the task to its completion time.
            map.put(task,time);
        }
        return time;
    }
}