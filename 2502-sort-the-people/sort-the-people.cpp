class Solution {
public:
    vector<string> sortPeople(vector<string>& names, vector<int>& heights) 
    {
        vector<pair<int,string>> people;
        for(int i=0;i<names.size();i++)
        {
            pair<int,string> p;
            p.first=heights[i];
            p.second=names[i];
            people.push_back(p);
        }

        sort(people.rbegin(),people.rend());

        vector<string> res;
        for(int i=0;i<people.size();i++)
        res.push_back(people[i].second);

        return res;
    }
};