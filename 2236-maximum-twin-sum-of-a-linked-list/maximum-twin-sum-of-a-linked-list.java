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

    private ListNode reverseList(ListNode curr)
    {
        ListNode prev=null;
        while(curr!=null)
        {
            ListNode nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        return prev;
    }

    public int pairSum(ListNode head) 
    {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode reversedHead=reverseList(slow);
        int maxTwinsum=-1;
        while(reversedHead!=null)
        {
            int sum=head.val+reversedHead.val;
            maxTwinsum=Math.max(maxTwinsum,sum);
            
            head=head.next;
            reversedHead=reversedHead.next;
        }
        return maxTwinsum;
    }
}