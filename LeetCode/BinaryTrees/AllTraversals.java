import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllTraversals {
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
    static class Pair{
        TreeNode node;
        int num;

        Pair(TreeNode node , int num){
            this.node = node;
            this.num = num;
        }
    }

    public static void all_Traversals(TreeNode root){
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,1));
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        if(root == null)return;
        while(!st.isEmpty()){
            Pair it = st.pop();
            //Logic is we always push with num value 1
            /*
            If stack top is value num =1 first add  in preorder increment num by 1 and add its left
            If num val is 2 add to inorder increment num by 1 and add its right
            If num val is 3 just add to postorder and pop.
             */
            if(it.num == 1){
                pre.add(it.node.val);
                it.num++;
                st.push(it);
                if(it.node.left!=null){
                    st.push(new Pair(it.node.left,1));
                }
            } else if (it.num==2) {
                in.add(it.node.val);
                it.num++;
                st.push(it);
                if(it.node.right!=null){
                    st.push(new Pair(it.node.right,1));
                }
            }
            else{
                post.add(it.node.val);
            }
        }
        System.out.println("Preorder Traversal -> "+pre);
        System.out.println("Inorder Traversal -> "+in);
        System.out.println("Postorder Traversal -> "+post);
      }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right = new TreeNode(7);
        all_Traversals(root);
    }
}
