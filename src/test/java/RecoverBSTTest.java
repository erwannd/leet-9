import org.junit.Test;

public class RecoverBSTTest {
    RecoverBST rec = new RecoverBST();

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
     */
    @Test
    public void testRecoverTree2() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        rec.recoverTree(root);
        root.printPreorder();
    }
}