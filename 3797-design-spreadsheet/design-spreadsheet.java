public class Spreadsheet {

    private int[][] grid;
    public Spreadsheet(int rows) 
    {
        // Initialize 1-indexed row and 26 columns (A-Z)
        grid = new int[rows + 1][26];
    }

    private int solve(String s) 
    {
        char ch = s.charAt(0);
        if (Character.isUpperCase(ch)) 
        {
            // It's a cell like A1, B10 etc.
            int[] rowCol = findRowCol(s);
            int row = rowCol[0], col = rowCol[1];
            return grid[row][col];
        }
        // It's a number
        return Integer.parseInt(s);
    }

    private int[] findRowCol(String cell) 
    {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)); // supports 1-2 digit row
        return new int[]{row, col};
    }

    public void setCell(String cell, int value) 
    {
        int[] rowCol = findRowCol(cell);
        grid[rowCol[0]][rowCol[1]] = value;
    }

    public void resetCell(String cell) 
    {
        setCell(cell, 0);
    }

    public int getValue(String formula) 
    {
        int plusIndex = formula.indexOf('+');
        String part1 = formula.substring(1, plusIndex); // exclude '='
        String part2 = formula.substring(plusIndex + 1);

        int val1 = solve(part1);
        int val2 = solve(part2);

        return val1 + val2;
    }
}
