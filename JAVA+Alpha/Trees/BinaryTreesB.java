
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;



public class BinaryTreesB{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }

    static class BinaryTree{
        static int idx=-1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newnode = new Node(nodes[idx]);
            newnode.left = buildTree(nodes);
            newnode.right=buildTree(nodes);
            return newnode;
        }

        public static void preOrder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);

        }

        public static void inOrder(Node root){
            if(root == null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }

        public static void postOrder(Node root){
            if(root == null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }

        public static void levelOrder(Node root){
            if(root == null){
                return;
            } 
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node curNode = q.remove();
                if(curNode ==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    System.out.print(curNode.data+" ");
                    if(curNode.left!=null){
                        q.add(curNode.left);
                    }
                    if(curNode.right!=null){
                        q.add(curNode.right);
                    }
                }
            }
        }
    }

    public static int height(Node root){
            if(root == null){
                return 0;
            }
            int lh= height(root.left);
            int rh=height(root.right);
            return Math.max(rh, lh)+1;
        }

        public static int countNode(Node root){
            if(root==null){
                return 0;
            }
            int lcount = countNode(root.left);
            int rcount = countNode(root.right);
            return lcount+rcount+1;
        }

        public static int sumOfNodes(Node root){
            if(root==null){
                return 0;
            }
            int leftSum = sumOfNodes(root.left);
            int rightSum=sumOfNodes(root.right);
            return leftSum+rightSum+root.data;
        }

    public static int diameter2(Node root){
        if(root ==null){
            return 0;
        }

       int lDiam = diameter2(root.left);
       int  lh = height(root.left);
       int rDiam = diameter2(root.right);
       int rh = height(root.right);  
       int selfDiam = lh +rh +1;
       return Math.max(selfDiam, Math.max(rDiam, lDiam));
    }

    static class Info{
        int diam;
        int height;

        public Info(int diam , int height){
            this.diam = diam;
            this.height=height;
        }
    }

    public static Info diameter(Node root){
        if(root ==null){
            return new Info(0,0);
        }

        Info leftInfo = diameter(root.left);
        Info righInfo = diameter(root.right);

       int diam = Math.max(Math.max(leftInfo.diam, righInfo.diam), leftInfo.height+righInfo.height+1);
       int ht = Math.max(leftInfo.height, righInfo.height);
       return new Info(diam,ht);
    }

    public static boolean isIdentical(Node root, Node subroot){
        if(root == null &&subroot==null){
            return true;
        }else if(root==null ||subroot==null||root.data!=subroot.data){
            return false;
        }
        if(!isIdentical(root.left, subroot.left)){
            return false;
        }
        if(!isIdentical(root.right, subroot.right)){
            return false;
        }
        return true;
    }

    public static boolean  isSubtree(Node root, Node subroot){
       if(root ==null){
        return false;
       }
       
        if(root.data == subroot.data){
            if(isIdentical(root,subroot)){
                return true;
            }
        }

        return isSubtree(root.left, subroot)||isSubtree(root.right, subroot);
    }

    static class Infoo{
        Node node;
        int hd;
        public Infoo(Node node , int hd){
            this.node=node;
            this.hd = hd;
        }
    }

    public static void topView(Node root){
        //level order traversal
        Queue<Infoo> q= new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();
        int  min = 0 , max=0;
        q.add(new Infoo(root,0));
        q.add(null);
        while(!q.isEmpty()){
            Infoo curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.hd)){
                //first time distance occurs
                map.put(curr.hd, curr.node);
            }
            if(curr.node.left !=null){
                q.add(new Infoo(curr.node.left,curr.hd-1));
                min =Math.min(min,curr.hd-1);
            }
            if(curr.node.right !=null){
                q.add(new Infoo(curr.node.right,curr.hd+1));
                max =Math.max(max,curr.hd+1);
            }
            }
            
        }

        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    }

    //Kth level of tree
    public static void kthLevel(Node root , int level , int k){
        if(root==null){
            return;
        }
        if(level == k){
            System.out.print(root.data+ " ");
            return;
        }
        kthLevel(root.left, level+1, k);
        kthLevel(root.right, level+1, k);
    }

    public static boolean getPath(Node root, int n ,ArrayList<Node> path){
        if(root ==null){
            return false;
        }
        path.add(root);
        if(root.data ==n){
            return true;
        }
       boolean foundleft= getPath(root.left, n, path);
    boolean foundright = getPath(root.right, n, path);
    if(foundleft ||foundright){
        return true;
    }
    path.remove(path.size()-1);
    return false;
    }

    //Least Common Ancestor
    public static Node lca(Node root , int n1 , int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root , n1 , path1);
        getPath(root,n2,path2);

       //lca 
       int i=0;
       for(;i<path1.size() && i<path2.size();i++){
           if(path1.get(i)!=path2.get(i)){
            break;
           }
       }
       
       //lca will be at i-1
        return path1.get(i-1);
        
    }

    public static Node lca2(Node root , int n1 , int n2){
        if(root==null||root.data ==n1 ||root.data ==n2 ){
            return root;
        }
        Node leftLca =lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        if(rightLca==null){
            return leftLca;
        }
        if(leftLca == null){
            return rightLca;
        }

        return root;
    }

    public static int lcaDist(Node root,int n){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);
        if(leftDist==-1 && rightDist==-1){
            return -1;
        }else if(leftDist ==-1){
            return rightDist+1;
        }else{
            return leftDist+1;
        }

    }

    //Minimum distance between two nodes
    public static int minDist (Node root, int n1,int n2){
        Node lca = lca2(root, n1, n2);
        int dist1=lcaDist(lca,n1);
        int dist2 = lcaDist(lca,n2);
        return dist1+dist2;
    }

    //Kth ancestor of a Node
    public static int kthAncestor(Node root, int n , int k){
        if(root ==null){
            return -1;
        }
        if(root.data ==n){
            return 0;
        }
        int leftDist = kthAncestor(root.left, n, k);
        int rightDist=kthAncestor(root.right, n, k);
        if(leftDist==-1 && rightDist ==-1){
            return -1;
        }
        int max =Math.max(leftDist, rightDist);
        if(max+1 ==k){
            System.out.println(root.data);
        }
        return max+1;

    }

    //Transform to Sum Tree
    public static int transform(Node root){
        if(root ==null){
            return 0;
        }
        int leftChild=transform(root.left);
        int rightChild=transform(root.right);
        int data = root.data;
        int newLeft = root.left ==null?0:root.left.data;
        int newRight =root.right ==null?0:root.right.data;
        root.data = newLeft +leftChild+newRight+rightChild;
        return data;
    
    }

    public static void main(String[] args) {     
    BinaryTree tree = new BinaryTree();
    Node root = new Node(1);
    root.left=new Node(2);
    root.right= new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    transform(root);
    tree.preOrder(root);
    }
}