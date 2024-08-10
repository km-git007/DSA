class Solution {
public:

    class Task {
        public:

        int index;
        int processingTime;
        int startTime;
        Task(int startTime,int processingTime,int index)
        {
            this->index=index;
            this->processingTime=processingTime;
            this->startTime=startTime;
        }
    };

    class myComparator {
    public:

        bool operator()(Task a,Task b)
        {
            // Min-heap based on processing time
            if(a.processingTime!=b.processingTime)
            return a.processingTime>b.processingTime;
            // If processingTime is the same, sort by index
            return a.index>b.index;

            // priority_queue mein ULTA LIKHNA PADTA HAI.
        }
    };
    

    vector<int> getOrder(vector<vector<int>>& tasks) 
    {
        int n=tasks.size();
        vector<Task> tasksList;
        for(int i=0;i<n;i++)
        tasksList.push_back(Task(tasks[i][0],tasks[i][1],i));

        // sorting tasksList based on increasing startTime.
        sort( tasksList.begin(), tasksList.end(), [](Task a,Task b){return a.startTime<b.startTime;});

        vector<int> order;
        priority_queue<Task,vector<Task>,myComparator> pq;
        int i=0;
        long time=0;
        while(i<n || !pq.empty())
        {
            // If CPU is sitting idle then currentTime becomes equal to the startTime of the next available task.
            if(pq.empty() && time<tasksList[i].startTime)
            time=tasksList[i].startTime;

            //  keep pushing tasks into queue while the enqueueing time of next task is lower than the current time!!
            while(i<n && time>=tasksList[i].startTime)
            {
                pq.push(tasksList[i]);
                i++;
            }
            // Why are we popping one by one?
            // Because we have pushed those Tasks whose starting Time was less than or equal to the current time.
            // So if you pop using a while loop then after finishing one Task which isnt in the queue yet 
            // but has become eligible to be in the queue due to its less processing Time and should be processed
            // next by the CPU will not get processed for not being in the queue.
            // tasks=[[1,2],[3,2],[3,5],[3,6],[4,1]]
            // here last task will be processed at the last if we use while loop.
            // rather its should be the third task to be processed.  
            Task t=pq.top();
            pq.pop();

            order.push_back(t.index);
            time+=t.processingTime;
        }
        return order;
    }
};