class Solution {

    private int n;
    private final int mod = (int) 1e9 + 7;
    int[][] directions = {
        {-2, -1}, // Up 2, Left 1
        {-1, -2}, // Up 1, Left 2
        {1, -2},  // Down 1, Left 2
        {2, -1},  // Down 2, Left 1
        {2, 1},   // Down 2, Right 1
        {1, 2},   // Down 1, Right 2
        {-1, 2},  // Up 1, Right 2
        {-2, 1}   // Up 2, Right 1
    };
    private int[][][] dp;
    private int solve(int row, int col, int jumps, int[][] board)
    {
        if(row < 0 || row >= 4 || col < 0 || col >=3 || board[row][col] == 1)
        return 0;

        if(jumps == n - 1)
        return 1;

        if(dp[row][col][jumps] != -1)
        return dp[row][col][jumps];

        int ways = 0;
        for(int[] dir : directions)
        {
            int r = row + dir[0];
            int c = col + dir[1];
            ways = (ways + solve(r, c, jumps + 1, board) % mod) % mod;
        }
        return dp[row][col][jumps] = ways;
    }

    public int knightDialer(int N) 
    {
        int[][] board = new int[4][3];
        // * and # are obstacles
        board[3][0] = 1; 
        board[3][2] = 1; 

        n = N;
        dp = new int [4][3][N];
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 3; j++)
            Arrays.fill(dp[i][j], -1);
        }

        int possiblePhoneNumbers = 0;
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 3; j++)
            if(board[i][j] == 0)
            possiblePhoneNumbers = (possiblePhoneNumbers + solve(i, j, 0, board) % mod) % mod;
        }
        return possiblePhoneNumbers;
    }
}