class Solution {
public:
    vector<pair<int,int>> directions={{0,1},{1,0},{0,-1},{-1,0}};   // R D L U
    vector<vector<int>> spiralMatrixIII(int n, int m, int rStart, int cStart) 
    {
        vector<vector<int>> ans;
        int steps=0;
        int dir=0;
        ans.push_back({rStart,cStart});
        while(ans.size()<m*n)
        {
            // no of steps change when we take a right or when we go down
            if(dir==0 || dir==2)
            steps++;

            for(int count=0;count<steps;count++)
            {
                rStart+=directions[dir].first;
                cStart+=directions[dir].second;

                if(rStart>=0 && rStart<n && cStart>=0 && cStart<m)
                ans.push_back({rStart,cStart});
            }
            // changing the direction
            dir=(dir+1)%4;
        }
        return ans;
    }
};