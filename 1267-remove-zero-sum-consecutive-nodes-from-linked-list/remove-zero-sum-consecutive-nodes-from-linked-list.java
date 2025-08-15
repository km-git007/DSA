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
    public ListNode removeZeroSumSublists(ListNode head) {
                ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        Map<Integer, ListNode> map = new HashMap<>();
        map.put(0, dummyHead);
        
        ListNode curr = head;
        int prefixSum = 0;
        while(curr != null){
            prefixSum += curr.val;
            if(map.containsKey(prefixSum)){
                ListNode ptr = map.get(prefixSum).next;
                int tempSum = prefixSum;
                // remove the prefix sum stored in the map
                while(ptr != curr){
                    tempSum += ptr.val;
                    map.remove(tempSum);
                    ptr = ptr.next;
                }
                // make connection
                map.get(prefixSum).next = curr.next;
            }else {
                map.put(prefixSum, curr);
            }
            curr = curr.next;
        }
        return dummyHead.next;
    }
}