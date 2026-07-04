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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) { 
        Queue<TreeNode> q = new LinkedList<>(); 
        List<List<Integer>> l = new ArrayList<>(); 
        
        if (root == null) return l; 
        
        q.add(root); 
        int lvl = 0; 
        
        while (!q.isEmpty()) { 
            int n = q.size(); 
            List<Integer> curr = new ArrayList<>(); 
            
            for (int i = 0; i < n; i++) { 
                TreeNode temp = q.remove(); 
                curr.add(temp.val); 
                
                if (temp.left != null) q.add(temp.left); 
                if (temp.right != null) q.add(temp.right); 
            } 
            
            if (lvl % 2 != 0) Collections.reverse(curr); 
            lvl++; 
            l.add(curr); 
        } 
        return l;
    } 
}

