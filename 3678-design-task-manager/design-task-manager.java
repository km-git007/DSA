class TaskManager {

    private class Task{
        int userId;
        int taskId;
        int priority;
        public Task(int userId, int taskId, int priority)
        {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }

    private Map<Integer,Task> map;
    private TreeSet<Task> taskSet;
    public TaskManager(List<List<Integer>> tasks) 
    {
        map = new HashMap<>();
        taskSet = new TreeSet<>((a, b) -> {
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
        taskSet.add(t);
    }
    
    public void edit(int taskId, int newPriority) 
    {
        Task oldTask = map.get(taskId);
        if (oldTask != null) 
        {
            taskSet.remove(oldTask); // Remove old entry
            Task newTask = new Task(oldTask.userId, taskId, newPriority);
            map.put(taskId, newTask);
            taskSet.add(newTask); // Insert updated task
        }
    }
    
    public void rmv(int taskId) 
    {
        Task task = map.get(taskId);
        if (task != null) 
        {
            taskSet.remove(task);
            map.remove(taskId);
        }
    }
    
    public int execTop() 
    {
        if (taskSet.isEmpty()) 
        return -1;

        Task topTask = taskSet.first(); // Get highest-priority task
        taskSet.remove(topTask); // Remove from TreeSet
        map.remove(topTask.taskId); // Remove from HashMap

        return topTask.userId;
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