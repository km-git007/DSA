class Solution {
    public int[][] construct2DArray(int[] original, int n, int m) 
    {
        if(original.length!=m*n)
        return new int[][]{};

        int[][] ans=new int[n][m];
        for(int i=0;i<original.length;i++)
        {
            int col=i%m;
            int row=i/m;
            ans[row][col]=original[i];
        }
        return ans;
    }
}