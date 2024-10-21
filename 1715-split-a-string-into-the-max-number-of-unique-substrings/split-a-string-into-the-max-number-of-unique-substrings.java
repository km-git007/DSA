class Solution {

    private HashSet set = new HashSet<>();
    private int maxCount = 0;
    private void solve(String s,int index)
    {
        if(s.length() - index + set.size() < maxCount)
        return;

        if(index==s.length())
        {
            maxCount = Math.max(maxCount,set.size());
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=index ; i<s.length(); i++)
        {
            sb.append(s.charAt(i));
            if(!set.contains(sb.toString()))
            {
                set.add(sb.toString());
                solve(s,i+1);
                set.remove(sb.toString());
            }
        }
    }

    public int maxUniqueSplit(String s) 
    {
        solve(s,0);
        return maxCount;
    }
}