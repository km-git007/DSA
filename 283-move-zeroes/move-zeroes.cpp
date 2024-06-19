class Solution {
public:
    void moveZeroes(vector<int>& a) 
    {
        int index=0;
        for(int i=0;i<a.size();i++)
        {
            if(a[i]!=0)
            {
                swap(a[i],a[index]);
                index++;
            }
        }
        return;
    }
};