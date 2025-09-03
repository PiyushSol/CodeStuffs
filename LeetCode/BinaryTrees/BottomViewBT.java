import java.util.*;

public class BottomViewBT {
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
    static class Info {
        TreeNode node;
        int hd;

        Info(TreeNode node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static List<Integer> bottomView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null)return ans;
        Queue<Info> q = new LinkedList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        q.add(new Info(root,0));
        while(!q.isEmpty()){
            Info it = q.poll();
            int hd = it.hd;
            TreeNode node = it.node;
            map.put(hd,node.val);
            if(node.left!=null){
                q.offer(new Info(node.left,hd-1));
            }
            if(node.right!=null){
                q.offer(new Info(node.right,hd+1));
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left =new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        System.out.println(bottomView(root));
    }
}
