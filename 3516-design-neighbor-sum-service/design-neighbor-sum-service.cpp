class neighborSum {
public:
    int n,m;
    vector<int> dia[4]={{-1,-1},{-1,1},{1,-1},{1,1}};
    vector<int> adj[4]={{-1,0},{1,0},{0,-1},{0,1}};
    unordered_map<int,pair<int,int>> map;
    neighborSum(vector<vector<int>>& grid) 
    {
        n=grid.size();
        m=grid[0].size();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int adjSum=0;
                int diaSum=0;
                for(int k=0;k<4;k++)
                {
                    int adjRow=i+adj[k][0];
                    int adjCol=j+adj[k][1];
                    if(adjRow>=0 && adjRow<n && adjCol>=0 && adjCol<m)
                    adjSum+=grid[adjRow][adjCol];

                    int diaRow=i+dia[k][0];
                    int diaCol=j+dia[k][1];
                    if(diaRow>=0 && diaRow<n && diaCol>=0 && diaCol<m)
                    diaSum+=grid[diaRow][diaCol];
                }

                map[grid[i][j]]={adjSum,diaSum};
            }
        }
    }
    
    int adjacentSum(int value) 
    {
        return map[value].first;
    }
    
    int diagonalSum(int value) 
    {
        return map[value].second;
    }
};

/**
 * Your neighborSum object will be instantiated and called as such:
 * neighborSum* obj = new neighborSum(grid);
 * int param_1 = obj->adjacentSum(value);
 * int param_2 = obj->diagonalSum(value);
 */