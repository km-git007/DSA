class Solution {
    public long taskSchedulerII(int[] tasks, int space) 
    {
        long time=0;
        HashMap<Long,Long> map=new HashMap<>();
        for(int task : tasks)
        {
            if(map.containsKey((long)task))
            time=Math.max(map.get((long)task)+space,time);
            // Complete the current task
            time++;
            // Map the task to its completion time.
            System.out.println(task+"-"+time);
            map.put((long)task,time);
        }
        return time;
    }
}