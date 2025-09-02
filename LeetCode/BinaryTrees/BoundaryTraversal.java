import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
    static class TreeNode {
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

    public static boolean isLeaf(TreeNode root){
        if(root.left == null && root.right==null){
            return true;
        }
        return false;
    }

    public static void addLeftBoundary(TreeNode root, List<Integer>res){
        TreeNode curr =root.left;
        while (curr!=null){
            if(isLeaf(curr)==false){
                res.add(curr.val);
            }
            if(curr.left!=null){
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }

    }

    public static void addRightBoundary(TreeNode root, List<Integer>res){
        ArrayList<Integer> temp = new ArrayList<>();
        TreeNode curr= root.right;
        while (curr!=null){
            if(!isLeaf(curr)){
                temp.add(curr.val);
            }
            if(curr.right!=null){
                curr=curr.right;
            }
            else{
                curr = curr.left;
            }
        }
        int i;
        for(i= temp.size()-1;i>=0;i--) {
            res.add(temp.get(i));
        }
    }

    public static void addLeaves(TreeNode root, List<Integer>res){
        if(isLeaf(root)){
            res.add(root.val);
            return;
        }
        if (root.left != null) {
            addLeaves(root.left,res);
        }
        if(root.right!=null){
            addLeaves(root.right,res);
        }
    }

    public static List<Integer> boundaryTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root==null)return res;
        if(isLeaf(root)==false){
            res.add(root.val);
        }
        addLeftBoundary(root,res);
        addLeaves(root,res);
        addRightBoundary(root,res);
        return res;
    }
}
