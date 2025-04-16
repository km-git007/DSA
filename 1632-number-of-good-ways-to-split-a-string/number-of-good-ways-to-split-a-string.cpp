class Solution {
public:
    int numSplits(string s) 
    {
        int n = s.length();
        unordered_map<char, int> leftMap, rightMap;
        
        // Initialize rightMap with frequency of all characters in the string
        for(char ch : s) 
        rightMap[ch]++;
        
        int goodWays = 0;
        // Traverse the string and compute the number of distinct letters for left and right
        // Only go till n-1 to ensure non-empty sright
        for (int i = 0; i < n - 1; i++) 
        {  
            // Update leftMap with current character and update rightMap
            leftMap[s[i]]++;
            rightMap[s[i]]--;
            
            // Remove the character from rightMap if its count becomes 0
            if(rightMap[s[i]] == 0)
            rightMap.erase(s[i]);

            // Compare the distinct counts of the left and right part
            if(leftMap.size() == rightMap.size()) 
            goodWays++;
        }
        return goodWays;
    }
};
