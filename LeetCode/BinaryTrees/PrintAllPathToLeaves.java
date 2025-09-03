import java.util.ArrayList;
import java.util.List;

public class PrintAllPathToLeaves {
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

    public static List<List<Integer>> allRootToLeaf(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        if(root==null)return res;
        addPath(root,currentPath,res);
        return res;
    }

    public static void addPath(TreeNode root , List<Integer>currentPath,List<List<Integer>> res){
        List<Integer> temp = new ArrayList<>();
        if(root == null)return;
        currentPath.add(root.val);
        if(root.left == null && root.right ==null){
            res.add(new ArrayList<>(currentPath));
        }
        addPath(root.left,currentPath,res);
        addPath(root.right,currentPath,res);
        currentPath.remove(currentPath.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root =new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        System.out.println(allRootToLeaf(root));
    }
}
