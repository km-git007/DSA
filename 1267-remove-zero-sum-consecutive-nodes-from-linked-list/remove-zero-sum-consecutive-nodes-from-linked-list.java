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
        ListNode dummy=new ListNode(-1);
        dummy.next=head;

        HashMap<Integer,ListNode> map=new HashMap<>();
        map.put(0,dummy);

        ListNode curr=head;
        int pSum=0;
        while(curr!=null)
        {
            pSum+=curr.val;
            if(map.containsKey(pSum))
            {
                int tempSum=pSum;
                ListNode node=map.get(pSum).next;
                while(node!=curr)
                {
                    tempSum+=node.val;
                    // removing the prefix sum corresponding to the elements which are going to get deleted.
                    map.remove(tempSum);
                    node=node.next;
                }
                // making the connection
                map.get(pSum).next=curr.next;
            }
            else
            map.put(pSum,curr);

            curr=curr.next;
        }
        return dummy.next;
    }
}