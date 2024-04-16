import java.util.ArrayList;
import java.util.List;

/**
 * You are given the root of a binary search tree (BST),
 * where the values of exactly two nodes of the tree were swapped by mistake.
 * Recover the tree without changing its structure.
 */
public class RecoverBST {
    /**
     * checkSubtree method will populate the array list with 2 nodes that are out of place.
     * After wards, we can swap the values in both nodes.
     */
    public void recoverTree(TreeNode root) {
        List<TreeNode> lst = new ArrayList<>();
        checkSubtree(root, new TreeNode(Integer.MIN_VALUE), new TreeNode(Integer.MAX_VALUE), lst);
        int temp = lst.get(0).val;
        lst.get(0).val = lst.get(1).val;
        lst.get(1).val = temp;
    }

    /**
     * The gist is to traverse the tree in preorder.
     * Using a min and max value, we can determine whether the current Node is out of place,
     * similar to the checkValidBST method. The difference here is that
     * we need to keep track of the nodes to swap. We do this by passing an array list.
     *
     * Whenever we find a node that is out of place, we add it and its ancestor to the list.
     * For instance:
     *            30
     *         /     \
     *       15       40
     *     /   \
     *    10   18
     *          \
     *          33
     * In this tree, the nodes to be swapped are 33 and 30.
     * Node 33 is out of place, because the left subtree of Node 30 must have a max value of 30.
     * Hence, we add Nodes 30 and 33 to the list = [30, 33]
     *
     * Sometimes, we have to modify the list further.
     * For instance:
     *            30
     *         /     \
     *       15       40
     *     /   \      /
     *    10   18    22
     *          \
     *          33
     * Similar to the problem above it, we found 33 is out of place.
     * We update our list = [30, 33].
     * But, when we evaluate the right subtree of 30,
     * we found another node that is out of place, node 22.
     * Here, we remove node 30 from our list, and insert node 22 as its replacement.
     * The list becomes [22, 33].
     *
     * We always insert the node with the smaller value first, so we can access it later
     * by its index. In this case, the node to be replaced is
     * greater than its replacement. But the reverse is also possible,
     * consider the case where we are given a tree like:
     *       30
     *      /
     *    40
     *   /
     *  50
     * When we reached node 40, we update the list = [30, 40].
     * Then we found that node 50 is out of place.
     * We removed 40 from the list and insert 50 in its place.
     * So the nodes to be swapped are 50 and 30.
     *
     * We need to do this modification at most once,
     * because the problem states that there are always 2 nodes that must be swapped.
     *
     * @param node the current node
     * @param min current node must be greater than min node.
     * @param max current node must be less than max node
     * @param lst a list containing 2 nodes that must be value-swapped
     */
    private void checkSubtree(TreeNode node, TreeNode min, TreeNode max, List<TreeNode> lst) {
        // if root.val is between min and max, it is at the right place
        if (node == null) {
            return;
        }

        if (node.val > max.val) {
            if (lst.isEmpty()) {
                lst.add(max);
                lst.add(node);
            } else {
                if (!(node.val < lst.get(1).val)) {
                    lst.set(1, node);
                }
            }
        }

        if (node.val < min.val) {
            if (lst.isEmpty()) {
                lst.add(node);
                lst.add(min);
            } else {
                if (!(node.val > lst.get(0).val)) {
                    lst.set(0, node);
                }
            }
        }

        // check leftSubtree
        checkSubtree(node.left, min, node, lst);

        // check rightSubtree
        checkSubtree(node.right, node, max, lst);
    }
}
