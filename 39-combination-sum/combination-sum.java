class Solution {
    private List<List<Integer>> res;
    private List<Integer> temp;
    private void solve(int[] candidates, int target, int index)
    {
        if(target == 0)
        res.add(new ArrayList<>(temp));

        for(int i = index; i < candidates.length; i++)
        {
            if(candidates[i] > target)
            break;

            temp.add(candidates[i]);
            solve(candidates, target - candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        
        Arrays.sort(candidates);
        solve(candidates, target, 0);
        return res;
    }
}