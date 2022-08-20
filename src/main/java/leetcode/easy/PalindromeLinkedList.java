package leetcode.easy;

import leetcode.utils.ListNode;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode middleNode = getMiddleNode(head);
        ListNode tail = reverseSecondHalf(middleNode);
        return checkIfPalindrome(head, tail);
    }

    private ListNode getMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast == null ? slow : slow.next;
    }

    private ListNode reverseSecondHalf(ListNode curr) {
        ListNode prev = null;
        while (curr != null) {
            ListNode oldNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = oldNext;
        }
        return prev;
    }

    private boolean checkIfPalindrome(ListNode head, ListNode tail) {
        while (head != null && tail != null) {
            if (head.val != tail.val) {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;
    }
}
