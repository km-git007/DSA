class MagicDictionary {

    private HashSet<String> set;
    public MagicDictionary() 
    {
        set=new HashSet<>();
    }
    
    public void buildDict(String[] dictionary) 
    {
        for(String word : dictionary)
        {
            set.add(word);
        }
    }
    
    public boolean search(String searchWord) 
    {
        StringBuilder sb = new StringBuilder(searchWord);
        for(int i=0;i<sb.length();i++)
        {
            char ch=sb.charAt(i);
            for(char c='a';c<='z';c++)
            {
                if(c==ch) continue;
                 
                sb.setCharAt(i,c);
                if(set.contains(sb.toString()))
                return true;
            }
            sb.setCharAt(i,ch);
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */