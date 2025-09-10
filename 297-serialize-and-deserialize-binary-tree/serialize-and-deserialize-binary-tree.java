public class Codec {

    private void serializationHelper(TreeNode root, StringBuilder builder) {
        if(root == null){
            builder.append("#,");
            return;
        }

        builder.append(String.valueOf(root.val)).append(",");
        serializationHelper(root.left, builder);
        serializationHelper(root.right, builder);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serializationHelper(root, builder);
        return builder.toString();
    }

    private TreeNode deserializationHelper(Queue<String> queue) {
        String node = queue.poll();
        if(node.equals("#")) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = deserializationHelper(queue);
        root.right = deserializationHelper(queue);
        return root;
    }

    private int index;
    private TreeNode deserializationHelper(String[] array) {
        if(index >= array.length || array[index].equals("#")) {
            index++;
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(array[index++]));
        root.left = deserializationHelper(array);
        root.right = deserializationHelper(array);
        return root;
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] array = data.split(","); 
        index = 0; 
        return deserializationHelper(array);
    }

}
