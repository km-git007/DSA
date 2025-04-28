class Solution 
{
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();
    public void solve(int[] a, int index) 
    {
        ans.add(new ArrayList<>(temp)); // Add a copy of temp to ans

        for (int i = index; i < a.length; i++) 
        {
            temp.add(a[i]);
            solve(a, i + 1);
            temp.remove(temp.size() - 1); // Backtrack
        }
    }

    public List<List<Integer>> subsets(int[] a) 
    {
        solve(a, 0);
        return ans;
    }
}
