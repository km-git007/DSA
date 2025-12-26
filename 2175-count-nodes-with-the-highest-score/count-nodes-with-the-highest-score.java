class Solution {
    private long maxScore = 0;
    private int count = 0;
    private List<Integer>[] tree;

    private int dfs(int node, int n) {
        long score = 1;
        int size = 0;

        for (int child : tree[node]) {
            int childSize = dfs(child, n);
            size += childSize;
            score *= childSize;
        }

        int remaining = n - size - 1;
        if (remaining > 0) score *= remaining;

        if (score > maxScore) {
            maxScore = score;
            count = 1;
        } else if (score == maxScore) {
            count++;
        }

        return size + 1;
    }

    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parents[i]].add(i);
        }

        dfs(0, n);
        return count;
    }
}
