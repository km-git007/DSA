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
    public ListNode modifiedList(int[] nums, ListNode head) 
    {
        HashSet<Integer> set=new HashSet<>();
        for(int num : nums)
        set.add(num);

        ListNode dummyNode=new ListNode(-1);
        dummyNode.next=head;

        ListNode current=head,previous=dummyNode;
        while(current!=null)
        {
            if(set.contains(current.val))
            previous.next=current.next;
            else
            previous=current;

            current=current.next;
        }
        return dummyNode.next;
    }
}