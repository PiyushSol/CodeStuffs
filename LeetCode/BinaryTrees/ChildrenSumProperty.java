public class ChildrenSumProperty {
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

    public static void childrenSum(TreeNode root){
        if(root == null)return;
        int child =0;
        if (root.left != null) {
            child += root.left.val;
        }
        if(root.right!=null){
            child+=root.right.val;
        }
        if(child>= root.val)root.val = child;
        else{
            if(root.left!=null){
                root.left.val= child;
            }
            if(root.right!=null){
                root.right.val = child;
            }
        }
        childrenSum(root.left);
        childrenSum(root.right);
        int tot=0;
        if(root.left!=null) tot+=root.left.val;
        if(root.right!=null)tot+=root.right.val;
        if(root.left!=null ||root.right!=null)root.val=tot;
    }
}
