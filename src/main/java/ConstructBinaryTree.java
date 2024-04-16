/**
 * Given two integer arrays "inorder" and "postorder"
 * where "inorder" is the inorder traversal of a binary tree
 * and "postorder" is the postorder traversal of the same tree,
 * construct and return the binary tree.
 *
 * Example:
 *  inorder   = [9,3,15,20,7]
 *  postorder = [9,15,7,20,3]
 *  output    =
 *       3
 *     /  \
 *    9   20
 *       /  \
 *      15   7
 */
public class ConstructBinaryTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int start = 0;
        int end   = inorder.length - 1;
        return buildSubTree(inorder, postorder, start, end, end);
    }

    /**
     * Using the postorder array, we know the root of this tree, because in postorder,
     * the root is visited last.
     * We can get the value of root from postorder, figure out its index
     * in the inorder array (inorderIndex), and divide the inorder array into two halves.
     * Then recursively call build subtree on the left part and the right part.
     *
     * The challenge is to figure out which index in the postorder array should be the root (pEnd).
     * Initially, when we start off, pEnd is the last position. But this is not always the case
     * for successive calls to build subtree.
     * For the right side, figuring pEnd is straightforward. It is always the current pEnd - 1.
     * For the left side, pEnd is the size of the rightSubtree + the root.
     * We can calculate the size of rightSubtree by using end - inorderIndex.
     *
     * @param start the first index of inorder array
     * @param end the last index of inorder array
     * @param pEnd the index of postorder array to be selected as the root
     */
    private TreeNode buildSubTree(int[] inorder, int[] postorder, int start, int end, int pEnd) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new TreeNode(inorder[start]);
        }

        int rootVal        = postorder[pEnd];
        TreeNode root      = new TreeNode(rootVal);
        int inorderIndex   = findIndex(inorder, rootVal, start, end);
        /*
         * the root for the left subtree is given at index:
         * pEnd - len (rightSubtree + root)
         * on the postorder array.
         */
        int leftRootIndex  = pEnd - (end - inorderIndex + 1);
        // the root for the right subtree is given at index pEnd - 1 on the postorder array
        int rightRootIndex = pEnd - 1;
        root.left  = buildSubTree(inorder, postorder, start, inorderIndex - 1, leftRootIndex);
        root.right = buildSubTree(inorder, postorder, inorderIndex + 1, end, rightRootIndex);
        return root;
    }

    /**
     * Given a value and two indexes (start and end), find the index in the array
     * where this value occurs.
     * @param val the value
     */
    private int findIndex(int[] arr, int val, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == val)
                return i;
        }
        return -1;
    }
}
