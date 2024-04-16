import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }

    public void printPreorder() {
        printPreorder(this);
        System.out.println();
    }

    public void printPostorder() {
        printPostorder(this);
        System.out.println();
    }

    public void printInorder() {
        printInorder(this);
        System.out.println();
    }

    private void printPreorder(TreeNode curr) {
        if (curr != null) {
            System.out.print(curr.val + " ");
            printPreorder(curr.left);
            printPreorder(curr.right);
        }
    }

    private void printPostorder(TreeNode curr) {
        if (curr != null) {
            printPostorder(curr.left);
            printPostorder(curr.right);
            System.out.print(curr.val + " ");
        }
    }

    private void printInorder(TreeNode curr) {
        if (curr != null) {
            printInorder(curr.left);
            System.out.print(curr.val + " ");
            printInorder(curr.right);
        }
    }
}
