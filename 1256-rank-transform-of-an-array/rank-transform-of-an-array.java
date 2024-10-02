class Solution {
    public int[] arrayRankTransform(int[] arr) 
    {
        int n=arr.length;
        if(n==0)
        return arr;
        else if(n==1)
        return new int[]{1};

        int[] ans=new int [n];
        for(int i=0;i<n;i++)
        ans[i]=arr[i];
        Arrays.sort(ans);

        int rank=1;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(ans[0],rank);
        for(int i=1;i<ans.length;i++)
        {
            if(ans[i]!=ans[i-1])
            {
                rank++;
                map.put(ans[i],rank);
            }
        }

        for(int i=0;i<n;i++)
        ans[i]=map.get(arr[i]);

        return ans;
    }
}