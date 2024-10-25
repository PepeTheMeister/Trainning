package neetcode;


import java.util.ArrayList;
import java.util.List;

public class Trees {

    public class TreeNode{
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
    }

    public TreeNode invertTree(TreeNode root){

        if(root == null){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public List<List<Integer>> levelOrder(TreeNode root){

        List<List<Integer>> result = new ArrayList<>();
        // Breath search first
        java.util.LinkedList<TreeNode> q = new java.util.LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int l = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < l; i++){
                TreeNode node = q.poll();
                if(node != null){
                    level.add(node.val);
                    q.add(node.left);
                    q.add(node.right);
                }
            }
            if(!level.isEmpty()){
                result.add(level);
            }

        }

        return result;
    }

    public boolean isValidBST(TreeNode root) {

        //Depth First Search
        return helper(root, -2222222, 222222222);
    }

    public boolean helper(TreeNode node, int l, int r){
        if(node == null){
            return true;
        }

        if(!(node.val > l && node.val < r)){
            return false;
        }
        return helper(node.left, l, node.val) && helper(node.right, node.val, r);

    }

    public int maxDepth(TreeNode root){
        return (maxDepthHelper(root, 0, 0));
    }

    public int maxDepthHelper(TreeNode node, int maxDepth, int depth){
        if(node == null){
            return Math.max(maxDepth,depth);
        }
        depth++;

        return Math.max(maxDepthHelper(node.left, maxDepth, depth), maxDepthHelper(node.right, maxDepth, depth));

    }

    public boolean isSameTree(TreeNode p, TreeNode q){
        return isSameTreeHelper(p,q);
    }

    public boolean isSameTreeHelper(TreeNode p, TreeNode q){
        if(q == null && p == null){
            return true;
        }

        if(q == null || p == null){
            return false;
        }

        if(p.val != q.val){
            return false;
        }

        return isSameTreeHelper(p.left, q.left) && isSameTreeHelper(p.right, q.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot){

        return isSubTreeHelper(root.left, subRoot) &&
                isSubTreeHelper(root.right, subRoot) ;
    }

    public boolean isSubTreeHelper(TreeNode root, TreeNode subRoot){
        if(root == null){
            return false;
        }

        if(root.val == subRoot.val){
            if(root.left != null && subRoot.left != null &&
                    root.right != null && subRoot.right != null){
                if(root.left.val == subRoot.left.val &&
                        root.right.val == subRoot.right.val){
                    return true;
                }
            }
        }

        return isSubTreeHelper(root.left, subRoot) && isSubTreeHelper(root.right, subRoot);

    }

}
