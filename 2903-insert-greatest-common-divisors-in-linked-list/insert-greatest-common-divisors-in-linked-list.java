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

    private int getGCD(int a,int b)
    {
        while(b!=0)
        {
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) 
    {
        if(head.next==null)
        return head;

        ListNode curr=head.next;
        ListNode prev=head;
        while(curr!=null)
        {
            ListNode node=new ListNode(getGCD(curr.val,prev.val));
            prev.next=node;
            node.next=curr;

            prev=curr;
            curr=curr.next;
        }
        return head;
    }
}