class Solution {
    private Map<String, Integer> tripletToId; // maps (val, leftID, rightID) -> ID
    private Map<Integer, Integer> freq;       // counts occurrences of each ID
    private List<TreeNode> res;
    private int idCounter;

    private int getId(TreeNode root) {
        if (root == null) return 0; // 0 = null ID

        int leftId = getId(root.left);
        int rightId = getId(root.right);

        String triplet = root.val + "," + leftId + "," + rightId;

        int uid = tripletToId.getOrDefault(triplet, -1);
        if (uid == -1) {
            uid = ++idCounter;
            tripletToId.put(triplet, uid);
        }

        freq.put(uid, freq.getOrDefault(uid, 0) + 1);
        if (freq.get(uid) == 2) { // add only once
            res.add(root);
        }

        return uid;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        tripletToId = new HashMap<>();
        freq = new HashMap<>();
        res = new ArrayList<>();
        idCounter = 0;
        getId(root);
        return res;
    }
}
