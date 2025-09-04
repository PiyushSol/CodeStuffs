import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinTimetoBurnTree {
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

    public static int timeToBurnTree(TreeNode root, int start) {
        Map<TreeNode,TreeNode> map = new HashMap<>();
        TreeNode nodeStart = mapParent(root, map ,start);
        int max = findMaxDistance(map,nodeStart);
        return max;
    }

    public static TreeNode mapParent(TreeNode root,Map<TreeNode,TreeNode>map , int start){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode res = null;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.val == start)res = curr;
            if(curr.left!=null){
                q.offer(curr.left);
                map.put(curr.left,curr);
            }
            if(curr.right!=null){
                map.put(curr.right,curr);
                q.offer(curr.right);
            }
        }
        return res;
    }

    public static int findMaxDistance(Map<TreeNode,TreeNode>map , TreeNode start){
        Queue<TreeNode>q = new LinkedList<>();
        Map<TreeNode,Integer> visited = new HashMap<>();
        q.offer(start);
        visited.put(start,1);
        int maxi =0;
        while(!q.isEmpty()){
            int size = q.size();
            int fl=0;
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null && visited.get(curr.left)==null){
                    fl=1;
                    visited.put(curr.left,1);
                    q.offer(curr.left);
                }
                if(curr.right!=null && visited.get(curr.right)==null){
                    fl=1;
                    visited.put(curr.right,1);
                    q.offer(curr.right);
                }
                if(map.get(curr)!=null && visited.get(map.get(curr))==null){
                    visited.put(map.get(curr),1);
                    q.offer(map.get(curr));
                }
            }
            if(fl==1)maxi++;

        }
        return maxi;
    }
}
