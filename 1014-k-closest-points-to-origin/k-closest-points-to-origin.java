class Solution {
    public int[][] kClosest(int[][] points, int k) 
    {
        // Define a max-heap using a priority queue
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1]))
        );

        // Process each point
        for (int[] point : points) {
            // Add the point to the heap
            maxHeap.add(point);

            // If heap size exceeds k, remove the farthest point
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Prepare the result array
        int[][] result = new int[k][2];
        int index = 0;

        // Extract k closest points from the heap
        while (!maxHeap.isEmpty()) {
            result[index++] = maxHeap.poll();
        }

        return result;
    }
}