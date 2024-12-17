class Solution {
public:
    string repeatLimitedString(string s, int repeatLimit) 
    {
        int map[26] = {0};
        for(char c : s)
        map[c - 'a']++;

        string res = "";
        int right = 25, left = 25;
        while(right >= 0)
        {
            if(!map[right])
            {
                right--;
                continue;
            }

            // Determine how many times we can use this character
            int count = min(map[right], repeatLimit);

            // Add `count` occurrences of the current character
            res.append(count, 'a' + right);
            map[right] -= count;

            // If there are still occurrences left, break the sequence using the next largest char
            if(map[right] > 0)
            {
                left = min(right - 1, left);
                while(left >= 0)
                {
                    if(map[left])
                    {
                        map[left]--;
                        res.push_back('a' + left);
                        break;
                    }
                    left--;
                }

                // No smaller character available, return the result
                if(left < 0)
                return res;
            }
        }
        return res;
    }
};