class Solution {
public:
    bool isValid(vector<int>& dist,double hour,int speed)
    {
        double time=0;   // calculating the amount of time taken for given speed.

        for(int i=0;i<dist.size()-1;i++)
        {
            time+=ceil((double)dist[i]/speed);  
        }
        time+= (double)dist[dist.size()-1]/speed;  // time taken to cover the last distance
        if(time>hour)      
        return false;
        return true;
    }

    int minSpeedOnTime(vector<int>& dist, double hour) 
    {
        int e=1e7;
        int s=1;
        int res=-1;

        while(s<=e)
        {
            int mid=s+(e-s)/2;
            if(isValid(dist,hour,mid)) // this speed is fine
            {
                res=mid;
                e=mid-1;          // checking if the task can be done in speed lesser than what we took right now
            }
            else
                s=mid+1;   // means we need to increase the speed
        }

        return res;
    }
};