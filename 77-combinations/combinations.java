class Solution {
    public List<List<Integer>> solve(int n, int k,int index,List<Integer> temp,List<List<Integer>> ans)
    {
        if(k==0)
        {
            ans.add(new ArrayList<>(temp)); // Add a copy of temp
            return ans;
        }

        for(int i=index;i<=n;i++)
        {
            temp.add(i);
            solve(n,k-1,i+1,temp,ans);
            temp.remove(temp.size()-1);
        }
        return ans;
    }

    public List<List<Integer>> combine(int n, int k) 
    {
        List<Integer> temp=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        return solve(n,k,1,temp,ans);  
    }
}