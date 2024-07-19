class Solution {

    int totalChildren;
    int minimumUnfairness;
    int [] children;
    private void solve(int[] cookies,int index)
    {
        if(index==cookies.length)
        {
            int maxi=-1;
            for(int i=0;i<totalChildren;i++)
            maxi=Math.max(maxi,children[i]);

            minimumUnfairness=Math.min(minimumUnfairness,maxi);
            return;
        }

        for(int i=0;i<totalChildren;i++)
        {
            children[i]+=cookies[index];
            // Skip if any kid has more cookies than current "minimumUnfairness" cookies.
            if(children[i]<minimumUnfairness)
            solve(cookies,index+1);
            children[i]-=cookies[index];
        }
    }

    public int distributeCookies(int[] cookies, int k) 
    {
        totalChildren=k;
        children=new int[totalChildren];
        minimumUnfairness=Integer.MAX_VALUE;
        solve(cookies,0);
        return minimumUnfairness;
    }
}