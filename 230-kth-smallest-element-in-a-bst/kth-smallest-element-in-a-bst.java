class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { 
        this.val = val; 
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    private int count = 0;
    private int result = -1;
    public int kthSmallest(TreeNode root, int k) {
        count = 0; 
        result = -1;
        traverse(root, k);
        return result;
    }
    private void traverse(TreeNode node, int k) {
        if (node == null || count >= k) {
            return;
        }
        traverse(node.left, k);
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        traverse(node.right, k);
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solver = new Solution();
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.right = new TreeNode(2);
        int k1 = 1;
        System.out.println("Example 1 Output: " + solver.kthSmallest(root1, k1)); // Expected: 1
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.left.left.left = new TreeNode(1);
        int k2 = 3;
        System.out.println("Example 2 Output: " + solver.kthSmallest(root2, k2)); // Expected: 3
    }
}
