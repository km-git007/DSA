class Solution {
public:

    int giveTime(string& s)
    {
        int time=0;
        for(int i=0;i<s.size();i++)
        {
            if(i==':')
            continue;
            time=10*time+(s[i]-'0');
        }
        return time;
    }

    bool haveConflict(vector<string>& event1, vector<string>& event2) 
    {
        int event2StartTime=giveTime(event2[0]);
        int event2EndTime=giveTime(event2[1]);
        int event1StartTime=giveTime(event1[0]);
        int event1EndTime=giveTime(event1[1]);
        
        return event2StartTime<=event1EndTime && event1StartTime<=event2EndTime;
    }
};