class Solution {
    private void buildGraph(List<Integer>[] graph, int[][] prerequisites, int[] indegree){
        for (int[] prerequisite : prerequisites) {
            int priorCourse = prerequisite[1];
            int course = prerequisite[0];

            if (graph[priorCourse] == null) {
                graph[priorCourse] = new ArrayList<>();
            }
            graph[priorCourse].add(course);
            indegree[course]++;
        }
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        int[] indegree  = new int[numCourses];
        buildGraph(graph, prerequisites, indegree);

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        int processedCourses = 0;
        while(!queue.isEmpty()) {
            int course = queue.poll();
            processedCourses++;
            
            if(graph[course] == null) {
                continue;
            }

            for(int nextCourse : graph[course]) {
                indegree[nextCourse]--;
                if(indegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }

        return processedCourses == numCourses;
    }
}