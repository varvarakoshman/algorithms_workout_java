package leetcode.easy;

import leetcode.utils.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while (list2 != null && list1 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        if (list2 != null) {
            head.next = list2;
        } else if (list1 != null) {
            head.next = list1;
        }
        return dummy.next;
    }
}
