public class Ceil {
    static class TreeNode {
      int data;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { data = val; left = null; right = null; }
  }

    public static int ceil(TreeNode node , int val){
        int ans = -1;
        while (node!=null){
            if(node.data ==val){
                ans=node.data;
                return ans;
            }
            if(val> node.data){
                node = node.right;
            }
            else {
                ans= node.data;
                node = node.left;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right =new TreeNode(12);
        root.left.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);
        System.out.println(ceil(root,10));
    }
}
