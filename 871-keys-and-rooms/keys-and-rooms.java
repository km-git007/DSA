class Solution {
    private void dfs(int currentRoom, List<List<Integer>> rooms, boolean[] visited){
        if(visited[currentRoom]) return;
        
        visited[currentRoom] = true;
        for(int room : rooms.get(currentRoom)) {
            dfs(room, rooms, visited);
        }
    }
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n  = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(0, rooms, visited);
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }
}