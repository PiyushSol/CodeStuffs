import java.util.LinkedList;
import java.util.Queue;

public class CountTotalNodes {
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

    //More Optimised
    public static int countNodes(TreeNode root) {
        if(root==null)return 0;
        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);
        if(lh==rh)return ((2<<lh)-1);
        else{
            return 1+countNodes(root.right)+countNodes(root.left);
        }
    }

    public static int getRightHeight(TreeNode root){
        int cnt=0;
        while (root.right!=null){
            cnt++;
            root=root.right;
        }
        return cnt;
    }

    public static int getLeftHeight(TreeNode root){
        int cnt=0;
        while (root.left!=null){
            cnt++;
            root=root.left;
        }
        return cnt;
    }

    public static int countNodesI(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null) return 0;
        q.offer(root);
        int cnt =0;
        while(!q.isEmpty()){
            cnt++;
            TreeNode curr = q.poll();
            if(curr.left!=null){
                q.offer(curr.left);
            }
            if(curr.right!=null){
                q.offer(curr.right);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        TreeNode root =new TreeNode();
//        root.left=new TreeNode(2);
//        root.right=new TreeNode(3);
//        root.left.right = new TreeNode(5);
//        root.left.left=new TreeNode(4);
//        root.right.left = new TreeNode(6);
        System.out.println(countNodes(root));
    }

}
