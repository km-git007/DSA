class Solution {
public:
	int maxLength;
	unordered_set<string> set;
	unordered_map<string, int> dp;
	int solve(string word) 
    {
	    if(dp.count(word))
	    return dp[word];
	    
	    int maxlen = 1;
        string prefix = "";
        for(int i = 0; i < word.length(); i++)
        {
            string curr = prefix + word.substr(i + 1);
            
            if(set.count(curr))
            maxlen = max(maxlen, 1 + solve(curr));
            
            prefix.push_back(word[i]);
        }
        return dp[word] = maxlen;
	}

	int longestStrChain(vector<string>& words) 
    {
		maxLength = 1;

		for(string word : words)
		set.insert(word);
		
		for(int i = 0; i < words.size(); i++)
		maxLength = max(maxLength, solve(words[i]));
		return maxLength;
	}
};