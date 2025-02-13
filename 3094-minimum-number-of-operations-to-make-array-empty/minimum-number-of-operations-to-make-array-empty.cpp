class Solution {
public:
    int minOperations(vector<int>& nums) 
    {
        unordered_map<int, int> map;
        for(int num : nums)
        map[num]++;

        int rounds = 0;
        // Process each unique difficulty level
        for (auto it : map) 
        {
            int freq = it.second;

            // If there's only 1 num of a difficulty, it's impossible to complete
            if(freq == 1)
            return -1;

            // If freq is divisible by 3, use all 3-num rounds
            if(freq % 3 == 0)
            rounds += freq / 3;

            // Otherwise, take as many 3-num rounds as possible, and one 2-num round
            else 
            rounds += (freq / 3) + 1;
        }
        return rounds;
    }
};