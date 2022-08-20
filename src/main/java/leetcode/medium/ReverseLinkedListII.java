package leetcode.medium;

import leetcode.utils.ListNode;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode currNode = head;
        ListNode prevNode = null;
        int count = 0;
        while (count < left - 1) {
            prevNode = currNode;
            currNode = currNode.next;
            count++;
        }
        ListNode leftHead = reverseSubList(currNode, prevNode, count, right);
        return leftHead.equals(prevNode) ? head : leftHead;
    }

    private ListNode reverseSubList(ListNode currNode, ListNode leftPrev, int left, int right) {
        ListNode leftHead = currNode;
        ListNode prevNode = null;
        int offset = left;
        while (left < right) {
            ListNode oldNext = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = oldNext;
            left++;
        }
        if (leftPrev != null) {
            leftPrev.next = prevNode;
        }
        leftHead.next = currNode;
        return offset != 0 ? leftPrev : prevNode;
    }
}
