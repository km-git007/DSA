class Solution {
    private boolean isSimilar(String s, String t)
    {
        int diff = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) != t.charAt(i))
            diff++;

            if(diff > 2)
            return false;
        }

        return diff == 0 || diff == 2;
    }

    private List<Integer> [] buildAdj(int n, String[] strs)
    {
        List<Integer>[] adj = new ArrayList[n];

        // Initialize each list
        for (int i = 0; i < n; i++)
        adj[i] = new ArrayList<>(); 

        for(int i = 0; i < n; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                if(isSimilar(strs[i], strs[j]))
                {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }

        return adj;
    }

    private boolean[] vis;
    private void dfs(int node, List<Integer>[] adj)
    {
        if(vis[node])
        return;

        vis[node] = true;

        for(int nbr : adj[node])
        dfs(nbr, adj);
    }

    public int numSimilarGroups(String[] strs) 
    {
        int N = strs.length;
        var adj = buildAdj(N, strs);

        vis = new boolean[N];

        int count = 0;
        for(int i = 0; i < N; i++)
        {
            if(!vis[i])
            {
                dfs(i, adj);
                count++;
            }
        }

        return count;
    }
}