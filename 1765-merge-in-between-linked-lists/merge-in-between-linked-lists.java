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
    private ListNode getTail(ListNode curr)
    {
        while(curr.next != null)
        curr = curr.next;

        return curr;
    }

    private ListNode getMid(ListNode curr, int steps)
    {
        while(steps > 0)
        {
            curr = curr.next;
            steps--;
        }
        return curr;
    }

    public ListNode mergeInBetween(ListNode head1, int a, int b, ListNode head2) 
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head1;

        ListNode tail = getTail(head2);
        ListNode curr = dummy;

        // Move `curr` to the node before `a`
        for(int i = 0; i < a; i++)
        curr = curr.next;

        ListNode mid = getMid(curr.next, b - a + 1);
        curr.next = head2;
        tail.next = mid;

        return dummy.next;
    }
}