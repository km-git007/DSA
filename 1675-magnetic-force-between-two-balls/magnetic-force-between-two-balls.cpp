class Solution {
public:
    bool isValidMinForce(vector<int>& position,int m,int minForce) 
    {
        int ballCount=1;
        int ballPosition=position[0];
        for(int i=0;i<position.size();i++)
        {
            if(position[i]-ballPosition>=minForce)
            {
                ballPosition=position[i];
                ballCount++;
            }
            if(ballCount>=m)
            return true;
        }
        return false;
    }

    int maxDistance(vector<int>& position,int m) 
    {
        sort(position.begin(), position.end());
        int start=1;
        int end=position.back()-position.front();
        int result=0;

        while (start<=end) 
        {
            int mid=start+(end-start)/2;
            if (isValidMinForce(position,m,mid)) 
            {
                start=mid+1;
                result=mid;
            } 
            else 
                end=mid-1;
        }
        return result;
    }
};
