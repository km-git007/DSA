class Solution {
public:
    vector<int> findThePrefixCommonArray(vector<int>& A, vector<int>& B) 
    {
        int common = 0;
        int map[51] = {0};
        vector<int> res;
        for(int i = 0; i < A.size(); i++)
        {
            map[A[i]]++;
            if(map[A[i]] > 1)
            common++;

            map[B[i]]++;
            if(map[B[i]] > 1)
            common++;

            res.push_back(common);
        }
        return res;
    }
};