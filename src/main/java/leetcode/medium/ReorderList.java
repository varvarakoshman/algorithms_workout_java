package leetcode.medium;

import leetcode.utils.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode middle = getMiddleNode(head);
        ListNode tail = reverseSecondHalf(middle);
        reorder(head, tail);
    }

    private ListNode getMiddleNode(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow.next;
        slow.next = null;
        return middle;
    }

    private ListNode reverseSecondHalf(ListNode middle) {
        ListNode previous = null;
        ListNode curr = middle;
        while (curr != null) {
            ListNode oldNext = curr.next;
            curr.next = previous;
            previous = curr;
            curr = oldNext;
        }
        return previous;
    }

    private void reorder(ListNode head, ListNode tail) {
        ListNode previous = null;
        while (head != null && tail != null) {
            ListNode oldNextHead = head.next;
            ListNode oldNextTail = tail.next;
            head.next = tail;
            tail.next = oldNextHead;
            head = oldNextHead;
            previous = tail;
            tail = oldNextTail;
        }
        if (tail != null && previous != null) {
            previous.next = tail;
        }
    }
}
