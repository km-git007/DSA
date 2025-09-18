class Task implements Comparable<Task> {
    int userId, taskId, priority;
    public Task(int userId, int taskId, int priority) {
        this.userId = userId;
        this.taskId = taskId;
        this.priority = priority;
    }

    @Override
    public int compareTo(Task o) {
        if(this.priority == o.priority) {
            return o.taskId - this.taskId;
        }
        return o.priority - this.priority;
    }
}

class TaskManager {

    private TreeSet<Task> taskSet;
    private Map<Integer, Task> idToTaskMap;
    public TaskManager(List<List<Integer>> tasks) {
        idToTaskMap = new HashMap<>();
        taskSet = new TreeSet<>();
        for(List<Integer> task : tasks) {
            add(task.get(0), task.get(1), task.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task t = new Task(userId, taskId, priority);
        taskSet.add(t);
        idToTaskMap.put(taskId, t);
    }

    public void edit(int taskId, int newPriority) {
        Task oldTask = idToTaskMap.get(taskId);
        
        // remove the oldTask
        rmv(taskId);
        
        // add new task
        add(oldTask.userId, taskId, newPriority);
    }

    public void rmv(int taskId) {
        Task oldTask = idToTaskMap.get(taskId);
        //remove the old task from treeSet and Map
        taskSet.remove(oldTask);
        idToTaskMap.remove(taskId);
    }

    public int execTop() {
        if(taskSet.isEmpty()) {
            return -1;
        }
        
        Task topPriorityTask = taskSet.first();
        rmv(topPriorityTask.taskId);
        return topPriorityTask.userId;
    }
}