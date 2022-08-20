package leetcode.easy;

import leetcode.utils.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prevNode = null;
        while (head != null) {
            ListNode oldNext = head.next;
            head.next = prevNode;
            prevNode = head;
            head = oldNext;
        }
        return prevNode;
    }
}
