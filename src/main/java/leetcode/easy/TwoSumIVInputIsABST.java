package leetcode.easy;

import leetcode.utils.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class TwoSumIVInputIsABST {

    private Set<Integer> remainders = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        return checkNode(root, k, false);
    }

    private boolean checkNode(TreeNode currNode, int k, boolean isFound) {
        if (isFound) {
            return isFound;
        }
        if (currNode != null) {
            if (remainders.contains(currNode.val)) {
                isFound = true;
            } else {
                remainders.add(k - currNode.val);
            }
            isFound = checkNode(currNode.left, k, isFound) || checkNode(currNode.right, k, isFound);
        }
        return isFound;
    }
}
