/**
 * Given the head of a singly linked list, reverse the list,
 * and return the reversed list.
 * Example:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 */

package _0206_reverse_linked_list;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    /* 双指针 */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, current = head;
        while (current != null) {
            ListNode temp = current.next; // 记录顺序的下一个节点
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }
    /* 递归 */
    // a -> b ->) c <- d <- e ) 即 c 的 下个节点为 b
/*
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
 */
}
