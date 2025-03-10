class Solution {
public:
    bool check(char c)
    {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o'|| c == 'u';
    }

    long long greaterThanEqualToKConsonants(string word, int k)
    {
        int n = word.size();
        unordered_map<char, int> vowelMap;
        long long count = 0, consonants = 0, i = 0;
        for(int j = 0; j < n; j++)
        {
            char ch = word[j];

            if(check(ch))
            vowelMap[ch]++;

            else
            consonants++;

            while(i <= j && vowelMap.size() == 5 && consonants >= k)
            {
                count += (n - j);

                char ithChar = word[i];
                if(check(ithChar))
                {
                    vowelMap[ithChar]--;
                    if(vowelMap[ithChar] == 0)
                    vowelMap.erase(ithChar);
                }
                else
                {
                    consonants--;
                }

                i++;
            }
        }
        return count;
    }

    long long countOfSubstrings(string word, int k) 
    {
        return greaterThanEqualToKConsonants(word, k) - greaterThanEqualToKConsonants(word, k + 1);
    }
};