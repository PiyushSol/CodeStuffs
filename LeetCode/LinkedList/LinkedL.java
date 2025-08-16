public class LinkedL {
    static class Node{
        int data ;
        Node next;
        Node(int data ){
            this.data = data;
            this.next = null;
        }
    }

//    LinkedL head;
    public static Node deleteHead(Node head){
        if(head == null){
            return null;
        }
        head = head.next;
        return head;
    }

    public static Node deleteTail(Node head){
        if(head == null || head.next==null){
            return null;
        }
        Node temp = head;
        while(temp.next.next!=null){
            temp = temp.next;
        }
        temp.next =null;
        return head;
    }

    public static void print(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp =temp.next;
        }
        System.out.println("null");
        System.out.println();
    }

    public static void main(String[] args) {
        Node head= new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        print(head);
        head =deleteTail(head);
        print(head);
    }
}
