class Solution {
    private List<List<Integer>> res;
    private List<Integer> temp;
    private void solve(int num, int target, int k){
        if(target == 0 && k == 0){
            res.add(new ArrayList<>(temp));
            return;
        }

        if(num > 9){
            return;
        }

        // skip
        solve(num + 1, target, k);

        if(num <= target && k > 0){
            temp.add(num);
            solve(num + 1, target - num, k - 1);
            temp.removeLast();
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        solve(1, n, k);
        return res;
    }
}