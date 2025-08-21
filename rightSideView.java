//Approach - I am doing a level order traversal(BFS) and at each level I am visiting the rigt child , then left child. since we want the right view at each level we add the very first nodes's value to our result.
//Time complexity would be O(n) as we are visiting each node once
//space complexity would be O(n/2)=O(n) as at most we would have n/2 nodes in our queue which would the auxillary space consumed.
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return result;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                var cur = q.poll();
                if (cur.right != null)
                    q.offer(cur.right);
                if (cur.left != null)
                    q.offer(cur.left);
                if (i == 0)
                    result.add(cur.val);
            }
        }
        return result;
    }
}
