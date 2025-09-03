import java.util.*;

public class TopViewBT {
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
        int hd;

        Pair(TreeNode node , int hd){
            this.node =node;
            this.hd = hd;
        }
    }

    public static List<Integer> topView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        if(root==null)return ans;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p=q.poll();
            int hd = p.hd;
            TreeNode node = p.node;
            if(map.get(hd)==null){
                map.put(hd,node.val);
            }
            if(node.left!=null){
                q.add(new Pair(node.left,hd-1));
            }
            if(node.right!=null){
                q.add(new Pair(node.right,hd+1));
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
