class Solution {
    private List<List<Integer>> res;
    private List<Integer> temp;
    private void solve(int[] candidates, int target, int index)
    {
        if(target == 0)
        {
            res.add(new ArrayList<>(temp));
            return;
        }

        if(index >= candidates.length)
        return;

        // skip
        solve(candidates, target, index + 1);

        if(target < candidates[index])
        return;

        // pick
        temp.add(candidates[index]);
        solve(candidates, target - candidates[index], index);
        temp.remove(temp.size() - 1);
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