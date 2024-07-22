class Solution {
public:
    vector<string> sortPeople(vector<string>& names, vector<int>& heights) 
    {
        priority_queue<pair<int,string>> people;
        for(int i=0;i<names.size();i++)
        people.push({heights[i],names[i]});

        int i=0;
        while(!people.empty())
        {
            names[i]=people.top().second;
            people.pop();
            i++;

        }
        return names;
    }
};