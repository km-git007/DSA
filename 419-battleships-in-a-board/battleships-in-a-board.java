class Solution {

    // Directions for moving up, down, left, and right
    private static final int[] rowDir = {-1, 1, 0, 0};
    private static final int[] colDir = {0, 0, -1, 1};
    public int countBattleships(char[][] board) 
    {
        // **************For battleship having length more than 1 ************************
        //'X' which have only one neighbour as 'X' are the end/start point of a battleship.
        // end and start points will be different for such ships.
        // If total end and start point of such ships are 'a' and 'b' respectively then number of 
        // such ships is (a+b)/2.

        // **************For battleship having length exactly 1 ************************
        //'X' which have only 0 neighbour as 'X'.
        // end and start points will be same different for such ships.
        // If total end/start point of such ships is 'a' then number of such ships is 'a'.

        int n=board.length;
        int m=board[0].length;
        int battleships=0,endStartPoints=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='X')
                {
                    int neighbours=0;
                    for(int k=0;k<4;k++)
                    {
                        int row=i+rowDir[k];
                        int col=j+colDir[k];
                        if(row>=0 && row<n && col>=0 && col<m && board[row][col]=='X')
                        neighbours++;
                    }
                    if(neighbours==0)
                    battleships++;
                    else if(neighbours==1)
                    endStartPoints++;
                }
            }
        }
        return battleships+endStartPoints/2;
    }
}