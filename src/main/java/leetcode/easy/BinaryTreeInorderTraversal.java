package leetcode.easy;

import leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        addNodeValue(values, root);
        return values;
    }

    private void addNodeValue(List<Integer> values, TreeNode node) {
        if (node != null) {
            addNodeValue(values, node.left);
            values.add(node.val);
            addNodeValue(values, node.right);
        }
    }
}
