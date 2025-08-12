class Solution {
    private int findRoot(int n, int[] leftChild, int[] rightChild){
        Set<Integer> hasParent = new HashSet<>();
        for(int i = 0; i < n; i++){
            hasParent.add(leftChild[i]);
            hasParent.add(rightChild[i]);
        }

        // remove -1 from the set
        hasParent.remove(-1);

        // if size is n then there is no root
        // if size is < n - 1 then the tree is disconnected
        // Should have exactly n-1 nodes with parents (one root has no parent)
        if(hasParent.size() != n - 1) {
            return Integer.MAX_VALUE;
        }

        for(int i = 0; i < n; i++){
            if(!hasParent.contains(i)){
                return i;
            }
        }

        // unreachable statement
        return Integer.MAX_VALUE;
    }

    private boolean dfs(int node, int[] leftChild, int[] rightChild, Set<Integer> visited){
        if(node == -1){
            return true;
        }

        // Cycle detected
        if(visited.contains(node)){
            return false;
        }

        visited.add(node);
        return dfs(leftChild[node], leftChild, rightChild, visited) && dfs(rightChild[node], leftChild, rightChild, visited);
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild)
    {
        int root = findRoot(n, leftChild, rightChild);
        if(root == Integer.MAX_VALUE) return false;

        Set<Integer> visited = new HashSet<>();
        return dfs(root, leftChild, rightChild, visited) && visited.size() == n;
    }
}