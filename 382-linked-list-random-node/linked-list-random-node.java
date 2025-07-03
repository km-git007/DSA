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
    private final List<ListNode> nodeList = new ArrayList<>();
    private final Random rand = new Random();
    public Solution(ListNode head) 
    {
        while (head != null) 
        {
            nodeList.add(head);
            head = head.next;
        }
    }

    public int getRandom() 
    {
        int randomIndex = rand.nextInt(nodeList.size());
        return nodeList.get(randomIndex).val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */