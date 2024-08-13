class Solution {
    private List<Integer> list;
    private List<List<Integer>> ans;
    private void solve(int[] cand,int target,int index)
    {
        if(target==0)
        {
            ans.add(new ArrayList(list));
            return;
        }

        for(int i=index;i<cand.length;i++)
        {
            if(i!=index && cand[i]==cand[i-1])
            continue;

            if(target>=cand[i])
            {
                list.add(cand[i]);
                solve(cand,target-cand[i],i+1);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] cand, int target) 
    {
        ans=new ArrayList<>();
        list=new ArrayList<>();
        Arrays.sort(cand);

        solve(cand,target,0);
        return ans;
    }
}