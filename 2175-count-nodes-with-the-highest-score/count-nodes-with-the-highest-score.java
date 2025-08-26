class Solution {
private int treeSize, count;
    private long maxScore;
    private int sizeOfTree(int node, List<Integer> [] children){

        long score = 1;
        // including the current node
        int size = 1;

        for(int child : children[node]){
            int childSize = sizeOfTree(child, children);
            score *= childSize;
            size += childSize;
        }

        int rest = treeSize - size;
        if(rest > 0){
            score *= rest;
        }

        if(score > maxScore){
            maxScore = score;
            count = 1;
        }else if(score == maxScore){
            count++;
        }

        return size;
    }

    private void buildTree(int[] parents, List<Integer> [] children){
        for(int i = 0; i < parents.length; i++){
            children[i] = new ArrayList<>();
        }

        for(int i = 1; i < parents.length; i++){
            children[parents[i]].add(i);
        }
        return;
    }

    public int countHighestScoreNodes(int[] parents) {
        treeSize = parents.length;
        maxScore = count = 0;
        List<Integer> [] children = new ArrayList[parents.length];
        buildTree(parents, children);
        sizeOfTree(0, children);
        return count;
    }
}