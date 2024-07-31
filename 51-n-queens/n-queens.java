class Solution {

    private boolean isSafe(int row,int col)
    {
        for(int i=0;i<row;i++)
        {
            int qRow=i;
            int qCol=queen[i];
            if(col==qCol || Math.abs(row-qRow)==Math.abs(col-qCol))
            return false;
        }
        return true;
    }

    int n;
    int[] queen;
    char[][] charArray;
    List<List<String>> ans=new ArrayList<>();
    private void placeQueen(int row)
    {
        if(row==n)
        {
            List<String> list=new ArrayList<>();
            for (char[] charRow : charArray) 
            list.add(new String(charRow));

            ans.add(new ArrayList(list));
            return;
        }

        for(int col=0;col<n;col++)
        {
            if(isSafe(row,col))
            {
                charArray[row][col]='Q';
                queen[row]=col;
                placeQueen(row+1);
                queen[row]=0;
                charArray[row][col]='.';
            }
        }
    }

    public List<List<String>> solveNQueens(int boardSize) 
    {
        n=boardSize;
        queen=new int [n];

        charArray=new char[n][n];
        for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
        charArray[i][j]='.';

        placeQueen(0);
        return ans;
    }
}