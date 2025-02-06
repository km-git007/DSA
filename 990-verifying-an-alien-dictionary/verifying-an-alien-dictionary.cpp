class Solution {
public:
    bool isAlienSorted(vector<string>& words, string order) 
    {
        int map[26];
        for(int i = 0; i < order.length(); i++)
        map[order[i] - 'a'] = i;

        string prev = words[0];
        for(int k = 1; k < words.size(); k++)
        {
            int i = 0, j = 0;
            string curr = words[k];
            while(i < prev.length() && j < curr.length())
            {
                int ch1 = prev[i];
                int ch2 = curr[j];

                if(map[ch1 - 'a'] > map[ch2 - 'a'])
                return false;

                if(map[ch1 - 'a'] < map[ch2 - 'a'])
                break;

                i++;
                j++;
            }

            if(i < prev.length() && j == curr.length())
            return false;

            prev = curr;
        }
        return true;
    }
};