//Designing Browser History
public class Browser {
    static class Node{
        String url;
        Node next;
        Node prev;

        Node(String url){
            this.url = url;
            this.next = null;
            this.prev =null;
        }

        Node(String url , Node next1 , Node prev1){
            this.url=url;
            this.next =next1;
            this.prev =prev1;
        }
    }

    static Node curr;
    Browser(String homepage){
        curr = new Node(homepage);
    }

    //Visiting a url
    public static void visit(String url){
        Node newnode = new Node(url);
        curr.next = newnode;
        newnode.prev = curr;
        curr = newnode;
    }

    //Back to a page
    public static String back(int steps){
        while(steps>0){
            if(curr.prev!=null){
                curr = curr.prev;
            }else{
                break;
            }
            steps--;
        }
        return curr.url;
    }

    //Forward to a page
    public static String forward(int steps){
        while (steps>0){
            if(curr.next!=null){
                curr =curr.next;
            }else{
                break;
            }
            steps--;
        }
        return curr.url;
    }

    public static void main(String[] args) {
        Browser b = new Browser("www.google.com");
        visit("www.instagram.com");
        visit("www.piyushsol.com");
        visit("www.harrypotter.com");
        visit("www.leetcode.com");
        visit("www.takeyouforward.org");
        System.out.println(forward(1));
        System.out.println(back(3));
        System.out.println(forward(1));
    }

}
