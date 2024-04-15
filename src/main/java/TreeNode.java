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

    private TreeNode deserializeFromArray(Integer[] arr) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode();
        q.add(root);
        int index = 0;
        while (!q.isEmpty() && index < arr.length) {
            TreeNode prev;
            TreeNode current = q.remove();
            if (arr[index] != null) {
                current.val = arr[index];
                current.left = new TreeNode();
                q.add(current.left);
                current.right = new TreeNode();
                q.add(current.right);
            }
            index++;
        }
        return root;
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
