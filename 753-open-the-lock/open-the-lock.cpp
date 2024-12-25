class Solution {
public:
    int openLock(vector<string>& deadEnds, string target) 
    {
        // Initialize visited set with dead ends
        unordered_set<string> visited(deadEnds.begin(), deadEnds.end());
        
        // If the initial state is a dead end, return -1
        if (visited.count("0000")) return -1;
        
        // BFS setup
        queue<string> q;
        q.push("0000");
        visited.insert("0000"); // Mark the starting point as visited
        
        int turns = 0;
        
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                string curr = q.front();
                q.pop();
                
                // If we reach the target, return the number of turns
                if (curr == target) return turns;
                
                // Generate all possible next states
                for (int j = 0; j < 4; j++) {
                    string next = curr;
                    string prev = curr;
                    
                    // Increment and decrement the j-th wheel
                    next[j] = (curr[j] - '0' + 1) % 10 + '0'; // Next digit
                    prev[j] = (curr[j] - '0' + 9) % 10 + '0'; // Previous digit
                    
                    // Add valid states to the queue
                    if (!visited.count(next)) {
                        visited.insert(next);
                        q.push(next);
                    }
                    if (!visited.count(prev)) {
                        visited.insert(prev);
                        q.push(prev);
                    }
                }
            }
            turns++;
        }
        
        return -1; // Target is unreachable
    }
};