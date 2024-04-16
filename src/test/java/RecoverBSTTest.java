import org.junit.Test;

public class RecoverBSTTest {
    RecoverBST rec = new RecoverBST();

    /**
     *      1
     *    /  \
     *   3    2
     *   Expected: swap 1 and 3
     */
    @Test
    public void testRecoverTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        rec.recoverTree(root);
        root.printPreorder();
    }

    /**
     *      2
     *    /  \
     *   3    1
     *   Expected: swap 1 and 3
     */
    @Test
    public void testRecoverTree2() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        rec.recoverTree(root);
        root.printPreorder();
    }

    /**
     *        1
     *      /
     *     2
     *   /
     *  3
     *  Expected: swap 3 and 1
     */
    @Test
    public void testRecoverTree3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        rec.recoverTree(root);
        root.printPreorder();
    }

    /**
     *           30
     *        /     \
     *      15       40
     *    /   \     /
     *   10   18   22
     *         \
     *         33
     * Expected: swap 33 and 22
     */
    @Test
    public void testRecoverTree4() {
        TreeNode root = new TreeNode(30);
        root.left = new TreeNode(15);
        root.right = new TreeNode(40);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(18);
        root.right.left = new TreeNode(22);
        root.left.right.right = new TreeNode(33);
        rec.recoverTree(root);
        root.printPreorder();
    }
}