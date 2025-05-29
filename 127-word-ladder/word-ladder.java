class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        Set<String> wordSet = new HashSet<>();
        for(String word : wordList)
        wordSet.add(word);

        if(!wordSet.contains(endWord))
        return 0;

        Queue<String> bfsQueue = new LinkedList<>();
        bfsQueue.add(beginWord);

        int steps = 1;
        while(!bfsQueue.isEmpty())
        {
            int level = bfsQueue.size();
            while(level > 0)
            {
                String currWord = bfsQueue.poll();

                if(currWord.equals(endWord))
                return steps;

                char[] wordArray = currWord.toCharArray();
                for(int i = 0; i < wordArray.length; i++)
                {
                    char originalCharacter = wordArray[i];
                    for(char ch = 'a'; ch <= 'z'; ch++)
                    {
                        wordArray[i] = ch;
                        String newWord = new String(wordArray);
                        if(wordSet.contains(newWord))
                        {
                            bfsQueue.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    // Restore original
                    wordArray[i] = originalCharacter; 
                }
                level--;
            }
            steps++;
        }
        return 0;
    }
}