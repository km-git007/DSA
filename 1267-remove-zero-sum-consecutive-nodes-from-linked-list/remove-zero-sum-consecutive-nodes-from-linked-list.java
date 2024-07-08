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
    public ListNode removeZeroSumSublists(ListNode head) 
    {
        HashMap<Integer,ListNode> map=new HashMap<>();
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        map.put(0,dummy);
        ListNode curr=head;
        int pSum=0;
        while(curr!=null)
        {
            pSum+=curr.val;
            if(map.containsKey(pSum))
            {
                ListNode node=map.get(pSum).next;
                int tempSum=pSum;
                while(node!=curr)
                {
                    tempSum+=node.val;
                    map.remove(tempSum);
                    node=node.next;
                }
                map.get(pSum).next=curr.next;
            }
            else
            map.put(pSum,curr);

            curr=curr.next;
        }
        return dummy.next;
    }
}