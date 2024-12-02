class Solution {
public:
    int isPrefixOfWord(string sentence, string searchWord) 
    {
        // Create a stringstream object with the sentence
        stringstream ss(sentence); 
        string word;
        int index = 1;

        // Tokenize by space and store word with its index
        while (ss >> word) 
        {
            if(word.find(searchWord) == 0)
            return index;
            index++;
        }
        return -1;
    }
};