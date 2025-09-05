import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SerializeDeserializeBT {
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

     public static String serialize(TreeNode root) {
        if(root==null)return "";
         Queue<TreeNode> q = new LinkedList<>();
         StringBuilder s = new StringBuilder();
         q.offer(root);
         while (!q.isEmpty()){
             TreeNode curr = q.poll();
             if(curr==null) {
                 s.append("#,");
                 continue;
             }
                 s.append(curr.val+",");
                 q.offer(curr.left);
                 q.offer(curr.right);

         }
         return s.toString();
    }

    public  static TreeNode deserialize(String data) {
        if(data.isEmpty())return null;
        Queue<TreeNode> q = new LinkedList<>();
        String values[] = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.offer(root);
        for(int i=1;i< values.length;i++){
            TreeNode parent = q.poll();
            if(!Objects.equals(values[i], "#")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.offer(left);
            }
            if(!Objects.equals(values[++i],"#")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right=right;
                q.offer(right);
            }
        }
        return root;
    }
}
