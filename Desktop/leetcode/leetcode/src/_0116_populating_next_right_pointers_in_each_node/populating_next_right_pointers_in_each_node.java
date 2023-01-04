/**
 * Populate each next pointer to point to its next right node. If there is no next right node,
 * the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * Example:
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 */
package _0116_populating_next_right_pointers_in_each_node;

class Node {
        int val;
        Node left;
        Node right;
        Node next;
}

class Solution {
    public Node connect(Node root) {
        if (root == null || root.left == null) { // 无左子树或根为 null
            return root;
        }
        // 对下一层
        root.left.next = root.right; // 连接同一个父节点的两个子节点
        if (root.next != null) { // 不同父亲的子节点之间建立连接
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}