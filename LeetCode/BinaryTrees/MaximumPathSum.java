public class MaximumPathSum {
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

    public static int maxPathSum(TreeNode root) {
       int[] maxValue = new int[1];
       maxValue[0]= Integer.MIN_VALUE;
       helper(root,maxValue);
       return maxValue[0];
    }

    public static int helper(TreeNode root , int[] maxValue){
        if(root ==null){
            return 0;
        }
        int left = Math.max(0 , helper(root.left,maxValue));
        int right = Math.max(0 , helper(root.right,maxValue));
        maxValue[0] = Math.max(maxValue[0],left+right+root.val);
        return Math.max(left,right)+root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(maxPathSum(root));
    }
}
