import java.util.*;

public class VerticalOrderTraversal {
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
    static class Tuple{
        TreeNode node;
        int row;
        int col;

        Tuple(TreeNode node, int row , int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer ,TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            TreeNode node =tuple.node;
            int row= tuple.row;
            int col = tuple.col;
            if(!map.containsKey(row)){
                map.put(row,new TreeMap<>());
            }
            if(!map.get(row).containsKey(col)){
                map.get(row).put(col, new PriorityQueue<>());
            }
            map.get(row).get(col).offer(node.val);
            if(node.left!=null){
                q.offer(new Tuple(node.left,row-1,col+1));
            }
            if(node.right!=null){
                q.offer(new Tuple(node.right,row+1,col+1));
            }
        }
        List<List<Integer>>ans =new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> ys : map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> node: ys.values()){
                while(!node.isEmpty()){
                    ans.get(ans.size()-1).add(node.poll());
                }
            }
        }
        return ans;
    }
}
