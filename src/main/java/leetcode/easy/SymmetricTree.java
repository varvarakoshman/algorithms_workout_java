package leetcode.easy;

import leetcode.utils.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return checkIfSymmetric(root.left, root.right);
    }

    private boolean checkIfSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        } else if (leftNode == null || rightNode == null) {
            return false;
        }
        return leftNode.val == rightNode.val && checkIfSymmetric(leftNode.left, rightNode.right) &&
                checkIfSymmetric(leftNode.right, rightNode.left);
    }
}
