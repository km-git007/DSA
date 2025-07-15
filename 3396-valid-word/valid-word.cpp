class Solution {
public:
    bool isVowel(char ch)
    {
        ch = tolower(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    bool isValid(string word) 
    {
        if(word.length() < 3)
        return false;

        bool hasConsonant = false, hasVowel = false;
        for(char ch : word)
        {
            if(!isalnum(ch))
            return false;

            else if(isVowel(ch))
            hasVowel = true;

            else if(!isdigit(ch))
            hasConsonant = true;
        }
        return hasConsonant && hasVowel;
    }
};