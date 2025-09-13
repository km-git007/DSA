class Solution {
public:
    unordered_set<int> set;
    int count=0;
    void countSubsets(vector<int>& a, int k,int index)
    {
        if(index==a.size())
        {
            count++;
            return;
        }

        countSubsets(a,k,index+1);     // notPick

        if(!set.count(a[index]-k))
        {
            set.insert(a[index]);
            countSubsets(a,k,index+1);     // pick
            set.erase(a[index]);
        }
    }

    int beautifulSubsets(vector<int>& a, int k) 
    {
        sort(a.begin(),a.end());
        countSubsets(a,k,0);
        return count-1;    // -1 for empty subset.
    }
};