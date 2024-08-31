class Solution {

    private int n;
    private int totalQueens=0;
    private int[] queen=new int[9];
    private boolean check(int row,int col)
    {
        for(int i=0;i<row;i++)
        {
            int qCol=queen[i];
            int qRow=i;
            if(qCol==col || Math.abs(qRow-row)==Math.abs(qCol-col))
            return false;
        }
        return true;
    }

    private void solve(int row)
    {
        if(row>=n)
        {
            totalQueens++;
            return;
        }

        for(int col=0;col<n;col++)
        {
            if(check(row,col))
            {
                queen[row]=col;
                solve(row+1);
                queen[row]=-1;
            }
        }
    }

    public int totalNQueens(int n) 
    {
        Arrays.fill(queen,-1);
        this.n=n;
        solve(0);
        return totalQueens;
    }
}