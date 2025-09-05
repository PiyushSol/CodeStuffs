import java.util.HashMap;
import java.util.Map;

public class BuildTreeInorderandPreorder {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root = build(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }

    public static TreeNode build(int[]preorder, int preStart,int preEnd , int[]inorder,int inStart,int inEnd,Map<Integer,Integer>map){
        if(preStart>preEnd||inStart>inEnd)return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = map.get(root.val
        );
        int numsleft = inRoot - inStart;
        root.left = build(preorder,preStart+1,preStart+numsleft,inorder,inStart,inRoot-1,map);
        root.right = build(preorder,preStart+numsleft+1,preEnd,inorder,inRoot+1,inEnd,map);
        return root;

    }

    public static void main(String[] args) {
        int[] preorder ={3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

    }
}
