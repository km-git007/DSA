/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    // private List<ListNode> nodeList;
    private int size;
    private Map<Integer, ListNode> nodeMap;
    private final Random rand = new Random();
    public Solution(ListNode head) 
    {
        // nodeList = new ArrayList<>();
        nodeMap = new HashMap<>();
        int index = 0;
        while(head != null)
        {
            nodeMap.put(index, head);
            head = head.next;
            index++;
        }
        size = index;
    }
    
    public int getRandom() 
    {
        int randomIndex = rand.nextInt(size);
        return nodeMap.get(randomIndex).val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */