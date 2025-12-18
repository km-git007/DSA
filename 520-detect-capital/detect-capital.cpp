class Solution {
public:
    bool detectCapitalUse(string word) 
    {
        if(word[0] >= 'A' && word[0] <= 'Z'){
            return checkCaps(word);
        }

        // all letters should be small
        for(int i = 0; i < word.length(); i++){
            if(word[i] >= 'A' && word[i] <= 'Z'){
                return false;
            }
        }
        
        return true;
    }

    bool checkCaps(string word){
        if(word.length() == 1){
            return true;
        }

        // if second letter is 'CAPITAL' then allof then have to be 'CAPITAL'
        if(word[1] >= 'A' && word[1] <= 'Z'){
            for(int i = 2; i < word.length(); i++){
                if(word[i] >= 'a' && word[i] <= 'z'){
                    return false;
                }
            }
        }
        else{
            for(int i = 2; i < word.length(); i++){
                if(word[i] >= 'A' && word[i] <= 'Z'){
                    return false;
                }
            }
        }
        return true;
    }
};