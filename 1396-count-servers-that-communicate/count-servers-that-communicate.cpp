class Solution {
public:
    int countServers(vector<vector<int>>& grid) 
    {
        int n = grid.size();
        int m = grid[0].size();

        for(int i = 0; i < grid.size(); i++) 
        {
            // Initialize variables for rows
            int x = -1, y = -1; 
            for(int j = 0; j < grid[0].size(); j++) 
            {
                if(grid[i][j] != 0) 
                {   // Check if there's a server or marked server
                    if(x == -1 && y == -1) 
                    {
                        // Store position of the first server in this row
                        x = i; y = j; 
                    } else 
                    {   // Mark both as communicating
                        grid[x][y] = 2; 
                        grid[i][j] = 2;
                    }
                }
            }
        }

        for(int j = 0; j < grid[0].size(); j++) 
        {
            // Initialize variables for columns
            int x = -1, y = -1; 
            for(int i = 0; i < grid.size(); i++) 
            {
                if(grid[i][j] != 0) 
                {   // Check if there's a server or marked server
                    if(x == -1 && y == -1) 
                    {
                        // Store position of the first server in this column
                        x = i; y = j; 
                    } else 
                    {   // Mark both as communicating
                        grid[x][y] = 2; 
                        grid[i][j] = 2;
                    }
                }
            }
        }

        int servers = 0;
        for(int i = 0; i < grid.size(); i++)
        for(int j = 0; j < grid[i].size(); j++)
        // Increment count for each communicating server
        if(grid[i][j] == 2)
        servers++; 

        return servers;
    }
};