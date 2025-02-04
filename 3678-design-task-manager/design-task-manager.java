class TaskManager {

    private class Task{
        int userId;
        int taskId;
        int priority;
        boolean isRemoved;
        public Task(int userId, int taskId, int priority)
        {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
            isRemoved = false;
        }
    }

    private Map<Integer,Task> map;
    private Queue<Task> maxHeap;

    public TaskManager(List<List<Integer>> tasks) 
    {
        map = new HashMap<>();
        maxHeap = new PriorityQueue<>((a, b) -> {
            if(a.priority == b.priority)
            return b.taskId - a.taskId;
            return b.priority - a.priority;
        });

        for(var task : tasks)
        add(task.get(0), task.get(1), task.get(2));
    }
    
    public void add(int userId, int taskId, int priority) 
    {
        Task t = new Task(userId, taskId, priority);
        map.put(taskId, t);
        maxHeap.add(t);
    }
    
    public void edit(int taskId, int newPriority) 
    {
        // soft delete the old task
        Task task = map.get(taskId);
        task.isRemoved = true;

        // create a new task and add in the queue
        Task newTask = new Task(task.userId, taskId, newPriority);
        maxHeap.add(newTask);
        map.put(taskId, newTask);
    }
    
    public void rmv(int taskId) 
    {
        Task task = map.get(taskId);
        task.isRemoved = true;

        // remove the task from the map
        map.remove(taskId);
    }
    
    public int execTop() 
    {
        while(!maxHeap.isEmpty())
        {
            Task task = maxHeap.poll();
            if(!task.isRemoved)
            {
                map.remove(task.taskId);
                return task.userId;
            }
        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */