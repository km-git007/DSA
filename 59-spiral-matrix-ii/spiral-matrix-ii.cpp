class Solution {
public:
    vector<vector<int>> generateMatrix(int n) 
    {
        vector<vector<int>> ans(n,vector<int>(n));
        int top=0;
        int bottom=n-1;
        int left=0;
        int right=n-1;

        int a=1;
        while(top<=bottom and left<=right)
        {
            for(int j=left;j<=right;j++)  //left to right
            ans[top][j]=a++;
            top++;
            if(top>bottom)
            break;

            for(int i=top;i<=bottom;i++)  //top to bottom
            ans[i][right]=a++;
            right--;
            if(left>right)
            break;

            for(int j=right;j>=left;j--)  //right to left
            ans[bottom][j]=a++;
            bottom--;
            if(top>bottom)
            break;

            for(int i=bottom;i>=top;i--)  //bottom to top
            ans[i][left]=a++;
            left++;
            // if(left>right)
            // break;
        }
        return ans;
    }
};