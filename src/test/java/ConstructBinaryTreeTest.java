import org.junit.Test;

public class ConstructBinaryTreeTest {

    @Test
    public void test1() {
        ConstructBinaryTree cb = new ConstructBinaryTree();
        int[] io = {-4,-10,3,-1,7,11,-8,2};
        int[] po = {-4,-1,3,-10,11,-8,2,7};

        TreeNode tree = cb.buildTree(io, po);
        tree.printPostorder();
    }
}