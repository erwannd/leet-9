/**
 * Given two integer arrays inorder and postorder
 * where inorder is the inorder traversal of a binary tree
 * and postorder is the postorder traversal of the same tree,
 * construct and return the binary tree.
 *
 * Example:
 *  inorder   = [9,3,15,20,7]
 *  postorder = [9,15,7,20,3]
 */
public class ConstructBinaryTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int start = 0;
        int end   = inorder.length - 1;
        return buildSubTree(inorder, postorder, start, end, end);
    }

    private TreeNode buildSubTree(int[] inorder, int[] postorder, int start, int end, int pEnd) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new TreeNode(inorder[start]);
        }
        int rootVal        = postorder[pEnd];
        TreeNode root      = new TreeNode(rootVal);
        int inOrderIndex   = findIndex(inorder, rootVal, start, end);
        // pEnd - len (rightSubtree + root)
        int leftRootIndex  = pEnd - (end - inOrderIndex + 1);
        int rightRootIndex = pEnd - 1;
        root.left  = buildSubTree(inorder, postorder, start, inOrderIndex - 1, leftRootIndex);
        root.right = buildSubTree(inorder, postorder, inOrderIndex + 1, end, rightRootIndex);
        return root;
    }

    private int findIndex(int[] arr, int val, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == val)
                return i;
        }
        return -1;
    }
}
