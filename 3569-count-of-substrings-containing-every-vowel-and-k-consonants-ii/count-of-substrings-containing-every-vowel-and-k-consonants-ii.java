class Solution {
    public boolean check(char c) 
    {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public long greaterThanEqualToKConsonants(String word, int k) 
    {
        int n = word.length();
        Map<Character, Integer> vowelMap = new HashMap<>();
        long count = 0;
        int consonants = 0;
        int i = 0;

        for (int j = 0; j < n; j++) 
        {
            char ch = word.charAt(j);

            if(check(ch)) 
            vowelMap.put(ch, vowelMap.getOrDefault(ch, 0) + 1);
            else 
            consonants++;

            while (i <= j && vowelMap.size() == 5 && consonants >= k) 
            {
                count += (n - j);

                char ithChar = word.charAt(i);
                if (check(ithChar)) 
                {
                    vowelMap.put(ithChar, vowelMap.get(ithChar) - 1);
                    if(vowelMap.get(ithChar) == 0)
                    vowelMap.remove(ithChar);
                }

                else 
                consonants--;

                i++;
            }
        }
        return count;
    }

    public long countOfSubstrings(String word, int k) 
    {
        return greaterThanEqualToKConsonants(word, k) - greaterThanEqualToKConsonants(word, k + 1);
    }
}
