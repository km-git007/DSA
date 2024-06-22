class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& a, int k) 
    {
        unordered_set<int> set;
        int i=0;
        for(int j=0;j<a.size();j++)
        {
            if(set.count(a[j])>0)
            return true;
            set.insert(a[j]);
            if(j-i==k)
            {
                set.erase(a[i]);
                i++;
            }
        }
        return false;
    }
};