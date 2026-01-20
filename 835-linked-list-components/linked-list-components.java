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
public int numComponents(ListNode head, int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) set.add(num);

    int components = 0;
    while (head != null) {
        // If current is in set...
        if (set.contains(head.val)) {
            // ...check if it is the END of a component
            // (i.e., next is null OR next is not in set)
            if (head.next == null || !set.contains(head.next.val)) {
                components++;
            }
        }
        head = head.next;
    }
    return components;
}
}