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
    private int lengthOfLinkedList(ListNode head){
        int length = 0;
        while(head != null){
            head = head.next;
            length++;
        }
        return length;
    }

    public ListNode swapNodes(ListNode head, int k) {
        int totalNodes = lengthOfLinkedList(head);
        ListNode node1 = head, node2 = head, curr = head;
        int length = 0;
        while(curr != null){
            length++;
            if(length == k){
                node1 = curr;
            }
            if(length == totalNodes - k + 1){
                node2 = curr;
            }
            curr = curr.next;
        }
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
        return head;
    }
}