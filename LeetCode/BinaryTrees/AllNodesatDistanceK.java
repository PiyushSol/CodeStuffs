import java.util.*;

public class AllNodesatDistanceK {
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

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> map = new HashMap<>();
        markParent(root,map,target);
        Map<TreeNode,Boolean> visited = new HashMap<>();
        Queue<TreeNode>q = new LinkedList<>();
        q.offer(target);
        visited.put(target,true);
        int cur_level =0;
        while(!q.isEmpty()){
            int s = q.size();
            if(cur_level==k)break;
            cur_level++;
            for(int i=0;i<s;i++){
                TreeNode node = q.poll();
                if(node.left!=null && visited.get(node.left)==null){
                    q.offer(node.left);
                    visited.put(node.left,true);
                }
                if(node.right!=null && visited.get(node.right)==null){
                    q.offer(node.right);
                    visited.put(node.right,true);
                }
                if(map.get(node)!=null && visited.get(map.get(node))==null){
                    q.offer(map.get(node));
                    visited.put(map.get(node),true);
                }
            }
        }

        List<Integer>res=new ArrayList<>();
        while (!q.isEmpty()){
            res.add(q.poll().val);
        }
        return res;
    }

    public static void markParent(TreeNode root, Map<TreeNode,TreeNode>map , TreeNode target){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left!=null){
                map.put(node.left,node);
                q.offer(node.left);
            }
            if(node.right!=null){
                map.put(node.right,node);
                q.offer(node.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        System.out.println(distanceK(root,root.left,2));
    }
}
