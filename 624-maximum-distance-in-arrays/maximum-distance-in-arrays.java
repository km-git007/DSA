class Solution {
    public int maxDistance(List<List<Integer>> arrays) 
    {
        int ans=0;
        int n=arrays.size();
        int maximum=arrays.get(0).get(arrays.get(0).size()-1);
        int minimum=arrays.get(0).get(0);
        for(int i=1;i<n;i++)
        {
            int currMaxi=arrays.get(i).get(arrays.get(i).size()-1);
            int currMini=arrays.get(i).get(0);
            ans=Math.max(ans,Math.abs(currMaxi-minimum));
            ans=Math.max(ans,Math.abs(maximum-currMini));
            maximum=Math.max(maximum,currMaxi);
            minimum=Math.min(minimum,currMini);
        }
        return ans;
    }
}