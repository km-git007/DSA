class Solution {
    private int timeToInformAll(int id, Map<Integer, List<Integer>> heirarchyMap, int[] informTime){
        if(!heirarchyMap.containsKey(id)){
            return 0;
        }

        int maxTime = 0;
        List<Integer> subordinates = heirarchyMap.get(id);
        for(int i = 0; i < subordinates.size(); i++){
            maxTime = Math.max(maxTime, timeToInformAll(subordinates.get(i), heirarchyMap, informTime));
        }
        return maxTime + informTime[id];
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> heirarchyMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            heirarchyMap.putIfAbsent(manager[i], new ArrayList<>());
            heirarchyMap.get(manager[i]).add(i);
        }
        return timeToInformAll(headID, heirarchyMap, informTime);
    }
}