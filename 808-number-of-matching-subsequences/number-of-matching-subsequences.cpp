class Solution {
public:
    int numMatchingSubseq(string s, vector<string>& words) 
    {
        int count=0;
        unordered_set<string> set;
        for(string word : words)
        {
            if(set.count(word)>0)
            {
                count++;
                continue;
            }

            int i=0,j=0;
            while(i<s.length() && j<word.length())
            {
                if(s[i]==word[j])
                j++;
                i++;
            }
            
            if(j==word.length())
            {
                count++;
                set.insert(word);
            }
        }
        return count;
    }
};