class Solution {
public:
    vector<string> commonChars(vector<string>& words) 
    {
        vector<int> common(26,INT_MAX);
        for(int i=0;i<words.size();i++)
        {
            vector<int> freq(26,0);
            for(char c : words[i])
            freq[c-'a']++;

            for(int j=0;j<26;j++)
            common[j]=min(common[j],freq[j]);
        }

        vector<string> ans;
        for(int i=0;i<26;i++)
        {
            if(common[i])
            {
                char c=char(i+'a');
                for(int j=0;j<common[i];j++)
                ans.push_back(string(1,c));
            }
        }
        return ans;
    }
};