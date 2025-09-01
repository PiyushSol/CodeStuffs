import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreOrder {
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
    public static void main(String[] args) {
    TreeNode node = new TreeNode(1);
    node.right = new TreeNode(2);
    node.right.left = new TreeNode(3);
    preorderTraversal(node);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
         List<Integer> tree = new ArrayList<>();
         if(root==null)return tree;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            root = st.pop();
            tree.add(root.val);
            if(root.right!=null){
                st.add(root.right);
            }
            if(root.left!=null){
                st.add(root.left);
            }
        }
        return tree;
    }
}
