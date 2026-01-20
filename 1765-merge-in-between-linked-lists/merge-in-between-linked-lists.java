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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode list2Head = list2;
        while(list2.next != null) {
            list2 = list2.next;
        }
        
        ListNode curr = list1;
        for(int i = 1; i <= a - 1; i++) {
            curr = curr.next;
        }
        
        ListNode nextNode = curr.next;
        curr.next = list2Head;
        
        for(int i = 1; i <= b - a + 1; i++) {
            nextNode = nextNode.next;
        }
        list2.next = nextNode;
        
        return list1;
    }
}