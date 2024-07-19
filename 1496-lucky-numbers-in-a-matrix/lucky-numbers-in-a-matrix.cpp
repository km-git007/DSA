class Solution {
public:
    vector<int> luckyNumbers(vector<vector<int>>& matrix) 
    {
        int n=matrix.size(),m=matrix[0].size();
        int maxRowMinimum=INT_MIN;
        int minColMaximum=INT_MAX;
        for(int i=0;i<n;i++)
        {
            int rowMin=INT_MAX;
            for(int j=0;j<m;j++)
            rowMin=min(matrix[i][j],rowMin);

            maxRowMinimum=max(rowMin,maxRowMinimum);
        }

        for(int j=0;j<m;j++)
        {
            int colMax=INT_MIN;
            for(int i=0;i<n;i++)
            colMax=max(matrix[i][j],colMax);

            minColMaximum=min(colMax,minColMaximum);
        }

        if(minColMaximum==maxRowMinimum)
        return {minColMaximum};

        return {};
    }
};