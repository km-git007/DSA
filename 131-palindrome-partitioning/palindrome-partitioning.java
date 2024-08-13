class Solution {
    private boolean isPallindrome(String s,int start,int end)
    {
        while(start<=end)
        {
            if(s.charAt(start++)!=s.charAt(end--))
            return false;
        }
        return true;
    }

    List<List<String>> ans=new ArrayList<>();
    List<String> list=new ArrayList<>();
    private void solve(String s,int index)
    {
        if(index>=s.length())
        {
            ans.add(new ArrayList(list));
            return;
        }

        for(int i=index+1;i<=s.length();i++)
        {
            if(isPallindrome(s,index,i-1))
            {
                String str=s.substring(index,i);
                list.add(str);
                solve(s,i);
                list.remove(list.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) 
    {
        solve(s,0);
        return ans;
    }
}