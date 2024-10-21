class Solution {

    private HashSet set = new HashSet<>();
    private int maxCount = 0;
    private void solve(String s,int index,int count)
    {
        if(index==s.length())
        {
            maxCount = Math.max(maxCount,count);
            System.out.println(set);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=index ; i<s.length(); i++)
        {
            sb.append(s.charAt(i));
            if(!set.contains(sb.toString()))
            {
                set.add(sb.toString());
                solve(s,i+1,count+1);
                set.remove(sb.toString());
            }
        }
    }

    public int maxUniqueSplit(String s) 
    {
        solve(s,0,0);
        return maxCount;
    }
}