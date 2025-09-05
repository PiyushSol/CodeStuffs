import java.util.HashMap;
import java.util.Map;

public class BuildTreeIPostorderandInorder {
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
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null||inorder.length==0||postorder.length==0)return null;
        Map<Integer,Integer>map = new HashMap<>();
        for(int i=0;i< inorder.length;i++){
            map.put(inorder[i],i);
        }

        TreeNode root = build(inorder,0, inorder.length-1 ,postorder,0,postorder.length-1,map);
        return root;
    }

    public static TreeNode build(int[]inorder,int is, int ie , int[]postorder,int ps,int pe,Map<Integer,Integer>map){
        if(is>ie || ps>pe)return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int inRoot = map.get(root.val);
        int numsleft = inRoot-is;
        root.left = build(inorder,is,inRoot-1,postorder,ps,ps+numsleft-1,map);
        root.right = build(inorder,inRoot+1,ie,postorder,ps+numsleft,pe-1,map);
        return root;
    }


}
