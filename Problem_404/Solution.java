package Problem_404;

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;

        }
        return countSumUnder(root, false);
    }

    // node 配下の left leaf node の値を合計する。
    private int countSumUnder(TreeNode node, boolean isLeftNode) {
        // Left leaf node
        if (node.left == null && node.right == null && isLeftNode) {
            return node.val;
        }

        int sum = 0;
        if (node.left != null) {
            sum += countSumUnder(node.left, true);
        }
        if (node.right != null) {
            sum += countSumUnder(node.right, false);
        }
        return sum;
    }
}
