class Solution {
    private boolean isVowel(char ch)
    {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    
    private String getKey(String word)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word.length(); i++)
        {
            char ch = Character.toLowerCase(word.charAt(i));
            if(isVowel(ch))
            sb.append('*');
            else
            sb.append(ch);
        }
        return sb.toString();
    }
    
    public String[] spellchecker(String[] wordlist, String[] queries) 
    {
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, String> caseInsensitiveMap = new HashMap<>();
        Set<String> wordSet = new HashSet<>();
        for(String word : wordlist)
        {
            String key = getKey(word);
            map.putIfAbsent(key, new LinkedHashSet<>());
            map.get(key).add(word);
            
            String wordInLowercase = word.toLowerCase();
            if(!caseInsensitiveMap.containsKey(wordInLowercase))
            caseInsensitiveMap.put(wordInLowercase, word);
            
            wordSet.add(word);
        }
        
        int n = queries.length;
        String[] result = new String[n];
        for(int i = 0; i < n; i++)
        {
            String query = queries[i];
            String queryInLowerCase = query.toLowerCase();
            if(wordSet.contains(query)){
                result[i] = query;
            }
            else if(caseInsensitiveMap.containsKey(queryInLowerCase)){
                result[i] = caseInsensitiveMap.get(queryInLowerCase);
            }
            else {
                
                String key = getKey(query);
                if(!map.containsKey(key)){
                    result[i] = "";
                }
                else {
                    var set = map.get(key);

                    if(set.contains(query))
                    result[i] = query;

                    else 
                    result[i] = set.iterator().next();
                }
            }
        }
        return result;
    }
}