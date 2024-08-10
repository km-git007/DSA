class Solution {
public:

    class Task {
        public:

        int index;
        int pTime;
        int startTime;
        Task(int startTime,int pTime,int index)
        {
            this->index=index;
            this->pTime=pTime;
            this->startTime=startTime;
        }
    };

    class myComparator {
    public:

        bool operator()(Task a,Task b)
        {
            // Min-heap based on processing time
            if(a.pTime!=b.pTime)
            return a.pTime>b.pTime;
            // If pTime is the same, sort by index
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
            if(pq.empty() && time<tasksList[i].startTime)
            time=tasksList[i].startTime;

            while(i<n && time>=tasksList[i].startTime)
            {
                pq.push(tasksList[i]);
                i++;
            }

            Task t=pq.top();
            pq.pop();

            order.push_back(t.index);
            time+=t.pTime;
        }
        return order;
    }
};