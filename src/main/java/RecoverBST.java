/**
 * You are given the root of a binary search tree (BST),
 * where the values of exactly two nodes of the tree were swapped by mistake.
 * Recover the tree without changing its structure.
 */
public class RecoverBST {
    public void recoverTree(TreeNode root) {
        checkSubtree(root, new TreeNode(Integer.MIN_VALUE), new TreeNode(Integer.MAX_VALUE));
    }

    private void checkSubtree(TreeNode node, TreeNode min, TreeNode max) {
        // if root.val is between min and max, it is at the right place
        if (node == null) {
            return;
        }

        if (node.val < min.val) {
            int temp = node.val;
            node.val = min.val;
            min.val  = temp;
        }

        if (node.val > max.val) {
            int temp = node.val;
            node.val = max.val;
            max.val  = temp;
        }

        // check leftSubtree
        checkSubtree(node.left, min, node);

        // check rightSubtree
        checkSubtree(node.right, node, max);
    }
}
