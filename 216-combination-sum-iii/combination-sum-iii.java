class Solution {
    private List<List<Integer>> res;
    private List<Integer> temp;
    private void solve(int startNum, int target, int k)
    {
        if(k == 0 && target == 0)
        {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int num = startNum; num < 10; num++)
        {
            if(num > target)
            break;

            // add
            temp.add(num);

            // explore
            solve(num + 1, target - num, k - 1);

            // backTrack
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) 
    {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        solve(1, n, k);
        return res;
    }
}