class Solution {
    private ListNode findMiddle(ListNode head){
        ListNode slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // disconnect the left half from the right
        prev.next = null;
        return slow;
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null, curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        if(head.next == null){
            return;
        }

        ListNode mid = findMiddle(head);
        ListNode head1 = reverse(mid);

        ListNode dummy = new ListNode(0), tail = dummy;
        while(head != null){
            tail.next = head;
            tail = tail.next;
            head = head.next;

            tail.next = head1;
            tail = tail.next;
            head1 = head1.next;
        }

        tail.next = head1;
    }
}