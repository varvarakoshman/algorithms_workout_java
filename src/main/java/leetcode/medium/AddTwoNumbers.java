package leetcode.medium;

import leetcode.utils.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryOver = 0;
        ListNode currentL1 = l1;
        ListNode currentL2 = l2;
        ListNode head = new ListNode();
        ListNode lastNode = head;
        int currentSum = 0;
        while (currentL1 != null || currentL2 != null) {
            int currentL1Value = getNodeValue(currentL1);
            int currentL2Value = getNodeValue(currentL2);
            int summingValue = currentL1Value + currentL2Value + carryOver;
            ListNode current = new ListNode();
            if (summingValue > 9) {
                current.val = summingValue % 10;
                carryOver = 1;
            } else {
                current.val = summingValue;
                carryOver = 0;
            }
            lastNode.next = current;
            lastNode = current;
            currentL1 = currentL1 == null ? null : currentL1.next;
            currentL2 = currentL2 == null ? null : currentL2.next;
        }
        if (carryOver == 1) {
            ListNode extraNode = new ListNode();
            extraNode.val = 1;
            lastNode.next = extraNode;
        }
        return head.next;
    }

    private int getNodeValue(ListNode node) {
        if (node == null) {
            return 0;
        } else {
            return node.val;
        }
    }
}
