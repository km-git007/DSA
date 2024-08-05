class Solution {
    private int []taken=new int[10];
    StringBuilder sb=new StringBuilder();
    String ans="~";
    private void solve(String pattern,int index)
    {
        if(index==pattern.length())
        {
            if(ans.compareTo(sb.toString())>0)
            ans=sb.toString();
            return;
        }

        if(sb.length()==0)
        {
            for(char i='1';i<='9';i++)
            {
                sb.append(i);
                taken[i-'0']=1;
                solve(pattern,0);
                taken[i-'0']=0;
                sb.deleteCharAt(0);
            }
        }
        else if(pattern.charAt(index)=='I')
        {
            int c=sb.charAt(sb.length()-1);
            for(char i=(char)(c+1);i<='9';i++)
            {
                if(taken[i-'0']==0)
                {
                    sb.append(i);
                    taken[i-'0']=1;
                    solve(pattern,index+1);
                    taken[i-'0']=0;
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        else
        {
            int c=sb.charAt(sb.length()-1);
            for(char i='1';i<=(char)(c-1);i++)
            {
                if(taken[i-'0']==0)
                {
                    sb.append(i);
                    taken[i-'0']=1;
                    solve(pattern,index+1);
                    taken[i-'0']=0;
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
    }
    public String smallestNumber(String pattern) 
    {
        solve(pattern,0);
        return ans;
    }
}