package leetcode.medium;

import leetcode.utils.ListNode;

public class DeleteTheMiddleNodeOfALinkedList {
    public ListNode deleteMiddle(ListNode head) {
        ListNode previous = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (previous == null) {
            head = null;
        } else {
            previous.next = slow.next;
        }
        return head;
    }
}
