public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "#";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    private TreeNode deserializationHelper(Queue<String> queue) {
        String node = queue.poll();
        if(node.equals("#")) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = deserializationHelper(queue);
        root.right = deserializationHelper(queue);
        return root;
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializationHelper(queue);
    }
}
