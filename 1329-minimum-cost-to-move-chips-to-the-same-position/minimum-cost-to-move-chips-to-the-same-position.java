class Solution {
    public int minCostToMoveChips(int[] position) {
        int[] map = new int[2];
        for(int pos : position){
            map[pos % 2]++;
        }
        return Math.min(map[0], map[1]);
    }
}