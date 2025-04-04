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
    private boolean isExtrema(int a, int b, int c)
    {
        return b > a && b > c || b < a && b < c;
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) 
    {
        ListNode curr = head.next;
        ListNode prev = head;

        int step = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        while(curr.next != null)
        {
            ListNode next = curr.next;

            if(isExtrema(prev.val, curr.val, next.val))
            stack.push(step);

            prev = curr;
            curr = curr.next;
            step++;
        }

        if(stack.size() < 2)
        return new int[]{-1, -1};

        int right = stack.peek(), minDiff = Integer.MAX_VALUE;
        while(stack.size() > 1)
        minDiff = Math.min(minDiff, stack.pop() - stack.peek());
        
        return new int[]{minDiff, right - stack.pop()};
    }
}