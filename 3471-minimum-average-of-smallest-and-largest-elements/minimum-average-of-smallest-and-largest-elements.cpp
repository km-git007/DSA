class Solution {
public:
    double minimumAverage(vector<int>& a) 
    {
        double minAverage=1e9;
        sort(a.begin(),a.end());
        int left=0,right=a.size()-1;
        while(left<right)
        {
            double avg=(a[left]+a[right])*1.0/2;
            minAverage=min(minAverage,avg);
            left++;
            right--;
        }
        return minAverage;
    }
};