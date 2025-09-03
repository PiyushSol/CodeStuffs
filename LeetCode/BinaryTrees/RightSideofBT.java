import java.util.ArrayList;
import java.util.List;

public class RightSideofBT {
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

    public static List<Integer> rightSideView(TreeNode root) {
      //We do reverse Preorder Traversal
        List<Integer> ans = new ArrayList<>();
        rightTraversal(root,0,ans);
        return ans;
    }

    public static void rightTraversal(TreeNode node ,int level ,List<Integer>ans){
        if(node == null)return;
        if(ans.size() == level){
            ans.add(node.val);
        }
        if(node.right!=null){
            rightTraversal(node.right,level+1,ans);
        }
        if(node.left!=null){
            rightTraversal(node.left,level+1,ans);
        }
    }
}
