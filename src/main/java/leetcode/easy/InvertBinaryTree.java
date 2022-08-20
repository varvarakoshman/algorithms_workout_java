package leetcode.easy;

import leetcode.utils.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        dfsAndRevert(root);
        return root;
    }

    private void dfsAndRevert(TreeNode node) {
        if (node != null && (node.left != null || node.right != null)) {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            dfsAndRevert(node.left);
            dfsAndRevert(node.right);
        }
    }
}
