class DSU{
    int[] parent, size;
    DSU(int n){
        size = new int[n];
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        Arrays.fill(size, 1);
    }

    public int find(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y){
        int parentX = find(x);
        int parentY = find(y);

        if(parentX == parentY){
            return;
        }
        
        if(size[parentX] <= size[parentY]){
            parent[parentX] = parentY;
            size[parentY] += size[parentX];
        }
        else{
            parent[parentY] = parentX;
            size[parentX] += size[parentY];
        }
    }

    public int[] getParent(){
        return parent;
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) 
    {
        int n = isConnected.length;
        DSU dsu = new DSU(n);
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(isConnected[i][j] == 0)
                continue;

                dsu.union(i, j);
            }
        }

        int count = 0;
        int[] parent = dsu.getParent();
        for(int i = 0; i < n; i++)
        {
            if(parent[i] == i)
            count++;
        }
        return count;
    }
}