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
        int minDiff = Integer.MAX_VALUE;
        int prevCritical = 0, firstCritical = 0;
        ListNode curr = head.next;
        ListNode prev = head;

        int currIndex = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        while(curr.next != null)
        {
            ListNode next = curr.next;

            if(isExtrema(prev.val, curr.val, next.val))
            {
                if(prevCritical == 0)
                firstCritical = currIndex;
                
                else
                minDiff = Math.min(minDiff, currIndex - prevCritical);

                prevCritical = currIndex;
            }

            prev = curr;
            curr = curr.next;
            currIndex++;
        }

        if(minDiff == Integer.MAX_VALUE)
        return new int[]{-1, -1};
        
        return new int[]{minDiff, prevCritical - firstCritical};
    }
}