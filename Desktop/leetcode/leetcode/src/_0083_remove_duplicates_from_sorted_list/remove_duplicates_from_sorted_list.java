package _0083_remove_duplicates_from_sorted_list;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    /* 递归 */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        if (head == null || head.next == null) {
            return head;
        }

        if (head.val == head.next.val) { // 假设 head 为去重链表，相等则跳过当前
            head.next = deleteDuplicates(head.next);
        } else { // 正常遍历
            head = deleteDuplicates(head.next);
        }
        return head;
    }
}
