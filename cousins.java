//Approach-Using DFS to traverse the tree, while checking if the target nodes are both from the same parent, if not, noting the height when there is a match. if there is a match and both the nodes doesnt have the same parent then based on the heigth we determine if they are cousins.
//Time complexity -O(n) as we are visiting each of the nodes once,
//Space complexity -O(h) h being the height(logn or n), this is the auxillary space consumed by the recursive stack.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    boolean xFound;
    boolean yFound;
    int xH;
    int yH;

    public boolean isCousins(TreeNode root, int x, int y) {

        this.yFound = false;
        this.xFound = false;
        this.xH = 0;
        this.yH = 0;
        helper(root, x, y, 0);
        return (xFound && yFound && (xH == yH));

    }

    private void helper(TreeNode root, int x, int y, int h) {
        if (root == null)
            return;
        if (root.left != null && root.right != null) {
            if ((root.left.val == x && root.right.val == y) ||
                    (root.right.val == x && root.left.val == y)) {
                return;
            }
        }
        if (root.val == x) {
            xFound = true;
            xH = h;
        }
        if (root.val == y) {
            yFound = true;
            yH = h;
        }
        helper(root.left, x, y, h + 1);
        helper(root.right, x, y, h + 1);
    }
}
