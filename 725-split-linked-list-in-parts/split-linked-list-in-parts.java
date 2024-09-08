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

    private int getLength(ListNode curr)
    {
        int length=0;
        while(curr!=null)
        {
            length++;
            curr=curr.next;
        }
        return length;
    }

    private ListNode makeList(ListNode curr,int k)
    {
        ListNode prev=null;
        while(curr!=null && k>0)
        {
            prev=curr;
            curr=curr.next;
            k--;
        }

        if(prev!=null)
        prev.next=null;
        return curr;
    }

    public ListNode[] splitListToParts(ListNode head, int k) 
    {
        ListNode[] ans=new ListNode[k];
        int length=getLength(head);

        if(length==0)
        return ans;

        ListNode curr=head;
        int size=length/k;
        int extraLength=length%k;
        for(int i=0;i<k;i++)
        {
            ans[i]=curr;
            int currentPartSize = size + (extraLength > 0 ? 1 : 0); // Distribute extra nodes
            curr=makeList(curr,currentPartSize);
            extraLength--;
        }
        return ans;
    }
}