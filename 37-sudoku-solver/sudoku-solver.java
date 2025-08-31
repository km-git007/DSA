class Solution {
    private boolean[][] rows, cols, boxes;
    private boolean check(int num, int i, int j){
        int index = (i / 3) * 3 + (j / 3);
        return !rows[i][num] && !cols[j][num] && !boxes[index][num];
    }

    private boolean solve(int row, int col, char[][] board){
        if(row >= 9){
            return true;
        }

        if(col >= 9){
            return (solve(row + 1, 0, board));
        }

        int index = (row / 3) * 3 + (col / 3);

        if(board[row][col] != '.'){
            int num = board[row][col] - '1';
            rows[row][num] = cols[col][num] = boxes[index][num] = true;
            return solve(row, col + 1, board);
        }

        for(char ch = '1'; ch <= '9'; ch++){
            int num = ch - '1';
            if(check(ch - '1', row, col)){
                board[row][col] = ch;
                rows[row][num] = cols[col][num] = boxes[index][num] = true;
                
                if(solve(row, col + 1, board)){
                    return true;
                }
                // backtrack
                rows[row][num] = cols[col][num] = boxes[index][num] = false;
                board[row][col] = '.';
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board){
        rows = new boolean[9][9];
        cols = new boolean[9][9];
        boxes = new boolean[9][9];
        // ✅ pre-mark given numbers
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int index = (i / 3) * 3 + (j / 3);
                    rows[i][num] = cols[j][num] = boxes[index][num] = true;
                }
            }
        }
        solve(0, 0, board);
    }
}