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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> l = new ArrayList<>();
        if(root == null) return l;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> al= new ArrayList<>();
            for(int i=n;i>0;i--){
                TreeNode nde = q.remove();
                al.add(nde.val);
                if(nde.left != null) q.offer(nde.left); 
                if(nde.right != null) q.offer(nde.right);
            }
            l.add(al);
        }
        return l;
    }
}