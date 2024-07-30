class NumMatrix {
public:
    vector<vector<int>> pSum;
    NumMatrix(vector<vector<int>>& matrix) 
    {
        int rows=matrix.size()+1;
        int cols=matrix[0].size()+1;
        pSum=vector<vector<int>>(rows,vector<int>(cols,0));
        for(int i=1;i<rows;i++)
        {
            for(int j=1;j<cols;j++)
            pSum[i][j]=pSum[i][j-1]+pSum[i-1][j]-pSum[i-1][j-1]+matrix[i-1][j-1];
        }
    }
    
    int sumRegion(int row1, int col1, int row2, int col2) 
    {
        return pSum[row2+1][col2+1]-pSum[row1][col2+1]-pSum[row2+1][col1]+pSum[row1][col1];
    }
};

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix* obj = new NumMatrix(matrix);
 * int param_1 = obj->sumRegion(row1,col1,row2,col2);
 */