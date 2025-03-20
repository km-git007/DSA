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
        map.put(0, dummy);

        ListNode curr=head;
        int pSum=0;
        while(curr!=null)
        {
            pSum += curr.val;
            if(map.containsKey(pSum))
            {
                ListNode node = map.get(pSum).next;
                int sum = pSum + node.val;
                while(sum != pSum)
                {
                    node = node.next;
                    map.remove(sum);
                    sum += node.val;
                }
                map.get(pSum).next = curr.next;
            }
            else
            map.put(pSum, curr);

            curr = curr.next;
        }
        return dummy.next;
    }
}