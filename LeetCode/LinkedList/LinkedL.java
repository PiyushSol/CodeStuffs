public class LinkedL {
    static class Node{
        int data ;
        Node next;
        Node(int data ){
            this.data = data;
            this.next = null;
        }
    }

    public static Node deleteK(Node head , int k){
        if(head==null)return null;
        if(k==1){
            head = head.next;
            return head;
        }
        int cnt=0;
        Node temp = head;
        Node prev = null;
        while(temp!=null){
            cnt++;
            if(cnt==k){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

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

    public static Node addHead(Node head , int data){
        Node newNode = new Node(data);
        if(head ==null){
            head = newNode;
            return head;
        }
        newNode.next = head;
        head = newNode;
        return head;
    }

    public static Node addLast(Node head, int data){
        Node newNode = new Node(data);
        if(head == null){
            return newNode;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    public static Node addK(Node head, int k , int data){
        if(head == null){
            if(k==1){
                return new Node(data);
            }
            else{
                System.out.println("Invalid Position");
                return null;
            }
        }
        Node newNode = new Node(data);
        if(k==1){
            addHead(head,data);
            return head;
        }

        int cnt =0;
        Node temp =head;
        while(temp.next!=null){
            cnt++;
            if(cnt == k-1){
                newNode.next = temp.next;
                temp.next=newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head= new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        print(head);
        head =addK(head,4,4);
        print(head);
    }
}
