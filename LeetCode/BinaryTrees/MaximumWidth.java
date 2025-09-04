import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidth {
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
        int index;

        Pair(TreeNode node , int index){
            this.node = node;
            this.index = index;
        }
    }

    public static int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        int ans =0;
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int sizee = q.size();
            int minn = q.peek().index;
            int first = 0 ,last =0;
            for(int i=0;i<sizee;i++){
                int curIdx = q.peek().index - minn;
                TreeNode node = q.peek().node;
                q.poll();
                if(i==0){
                    first =curIdx;
                }
                if(i==sizee-1){
                    last=curIdx;
                }
                if(node.left!=null){
                    q.offer(new Pair(node.left,curIdx*2+1));
                }
                if(node.right!=null){
                    q.offer(new Pair(node.right,curIdx*2+2));
                }
            }
            ans = Math.max(ans,last-first+1);
        }
        return ans;
    }
}
