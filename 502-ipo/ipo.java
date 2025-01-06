class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) 
    {
        // MaxHeap to store profits of feasible projects
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Create an array of pairs [capital, profit]
        int[][] projects = new int[profits.length][2];
        for (int i = 0; i < profits.length; i++) 
        {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        // Sort projects by the capital required
        Arrays.sort(projects, Comparator.comparingInt(a -> a[0]));

        int index = 0;
        // Perform at most k projects
        while (k > 0) {
            // Add all feasible projects to the maxHeap
            while (index < projects.length && w >= projects[index][0]) {
                maxHeap.add(projects[index++][1]);
            }

            // If no feasible project is available, break out
            if (maxHeap.isEmpty()) {
                break;
            }

            // Select the most profitable project
            w += maxHeap.poll();
            k--; // Decrement the number of projects allowed
        }

        return w;
    }
}