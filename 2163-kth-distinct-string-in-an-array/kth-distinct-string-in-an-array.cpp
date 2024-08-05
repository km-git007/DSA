class Solution {
public:
    string kthDistinct(vector<string>& arr, int k) 
    {
        unordered_map<string,int> map;
        for(string s : arr )
        map[s]++;

        int count=0;
        for(string s : arr)
        {
            if(map[s]==1)
            count++;
            
            if(count==k)
            return s;
        }
        return "";
    }
};