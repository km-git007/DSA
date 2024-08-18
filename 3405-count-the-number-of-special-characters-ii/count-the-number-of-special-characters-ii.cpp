class Solution {
public:
    int numberOfSpecialChars(string word) 
    {
        int map[26];
        memset(map,-1,sizeof(map));
        for(int i=0;i<word.length();i++)
        {
            if(word[i]>='A' && word[i]<='Z' && map[word[i]-'A']==-1)
            map[word[i]-'A']=i;
        }

        int count=0;
        int specialCharacters[26]={0};
        for(int i=0;i<word.length();i++)
        {
            if(word[i]<'a') continue;

            int position=map[word[i]-'a'];
            if(i<position)
            specialCharacters[word[i]-'a']=1;
            else
            specialCharacters[word[i]-'a']=0;
            // else statement is very important because if makes sure that if a character(lowerCase) appears more  
            // than once then even if it becomes a spl char in its earlier occurance its set to non special char again
            // if it fails the eligibility criteria.
        }

        for(int val : specialCharacters)
        count+=val;
        return count;
    }
};