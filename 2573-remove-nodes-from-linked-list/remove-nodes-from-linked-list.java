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
    public ListNode removeNodes(ListNode head) 
    {
        Deque<ListNode> stack = new ArrayDeque<>();
        while(head != null)
        {
            stack.push(head);
            head = head.next;
        }

        ListNode start = null;
        while(!stack.isEmpty())
        {
            ListNode curr = stack.pop();
            if(start == null || curr.val >= start.val)
            {
                curr.next = start;
                start = curr;
            }
        }
        return start;
    }
}