class Solution {
    private Set<Integer> parent, visited;
    private boolean dfs(int node, int[] leftChild, int[] rightChild){
        if(node == -1){
            return true;
        }

        if(visited.contains(node)){
            return false;
        }

        visited.add(node);

        return dfs(leftChild[node], leftChild, rightChild) && dfs(rightChild[node], rightChild, leftChild);
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        parent = new HashSet<>();
        visited = new HashSet<>();
        for(int i = 0; i < n; i++){
            if(parent.contains(leftChild[i]) || parent.contains(rightChild[i])){
                return false;
            }

            if(leftChild[i] != -1){
                parent.add(leftChild[i]);
            }

            if(rightChild[i] != -1){
                parent.add(rightChild[i]);
            }
        }

        int root = 0;
        for(int i = 0; i < n; i++){
            if(!parent.contains(i)){
                root = i;
                break;
            }
        }
        return dfs(root, leftChild, rightChild) && visited.size() == n;
    }
}