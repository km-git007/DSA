class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // Map to store the original node to its clone
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        // Initialize BFS
        queue.add(node);
        map.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();

            // Iterate through neighbors
            for (Node neighbor : currNode.neighbors) {
                if (!map.containsKey(neighbor)) {
                    // Clone the neighbor if not already cloned
                    map.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                // Add the cloned neighbor to the current node's neighbors
                map.get(currNode).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}
