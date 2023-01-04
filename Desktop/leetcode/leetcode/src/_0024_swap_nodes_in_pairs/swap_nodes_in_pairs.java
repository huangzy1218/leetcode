/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in
 * the list's nodes (i.e., only nodes themselves may be changed.)
 * Example:
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 */

package _0024_swap_nodes_in_pairs;

class ListNode {
    int val;
    ListNode next;ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        // 1. 终止条件
        if (head == null || head.next == null) {
            return head;
        }
        // 3. 本级递归操作
        ListNode nextNode = head.next;
        head.next = swapPairs(nextNode.next);
        nextNode.next = head;
        // 2. 返回值
        return nextNode;
    }
}
