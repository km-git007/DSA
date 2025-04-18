class Spreadsheet {
private:
    vector<vector<int>> grid;

    // Helper function to parse either a number or a cell reference
    int solve(const string &s) 
    {
        if (isupper(s[0])) 
        {
            // It's a cell reference like A1 or B10
            auto [row, col] = findRowCol(s);
            return grid[row][col];
        } 
        
        // It's a number
        return stoi(s);
    }

    // Converts a cell string like A1 or B10 to row, col
    pair<int, int> findRowCol(const string &cell) 
    {
        int col = cell[0] - 'A';
        int row = stoi(cell.substr(1)); // handles 1 or 2-digit row numbers
        return {row, col};
    }

public:
    Spreadsheet(int rows) {
        grid = vector<vector<int>>(rows + 1, vector<int>(26, 0)); // 1-indexed rows
    }

    void setCell(string cell, int value) 
    {
        auto [row, col] = findRowCol(cell);
        grid[row][col] = value;
    }

    void resetCell(string cell) 
    {
        setCell(cell, 0);
    }

    int getValue(string formula) 
    {
        size_t plusPos = formula.find('+');
        string part1 = formula.substr(1, plusPos - 1);  // exclude '='
        string part2 = formula.substr(plusPos + 1);

        int val1 = solve(part1);
        int val2 = solve(part2);

        return val1 + val2;
    }
};
