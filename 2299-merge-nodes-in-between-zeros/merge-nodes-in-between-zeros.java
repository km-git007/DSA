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
    public ListNode mergeNodes(ListNode head) 
    {
        int sum=0;
        ListNode curr=head.next;
        ListNode dummy=new ListNode(-1);
        ListNode tail=dummy;
        while(curr!=null)
        {
            if(curr.val==0)
            {
                curr.val=sum;
                tail.next=curr;
                tail=curr;
                sum=0;
            }
            else
            sum+=curr.val;
            curr=curr.next;
        }

        return dummy.next;
    }
}