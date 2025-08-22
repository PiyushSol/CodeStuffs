public class DLL {
    static class Node{
        int data ;
        Node next;
        Node prev;

        Node(int data,Node next1,Node prev1){
            this.data =data;
            this.next = next1;
            this.prev = prev1;
        }

        Node(int data ){
            this.data = data;
            this.next = null;
            this.prev=null;
        }
    }

    public static Node convert2L(int arr[]){
        Node head = new Node(arr[0]);
        Node prev= head;
        for(int i=1;i< arr.length;i++){
            Node n = new Node(arr[i],null,prev);
            prev.next = n;
            prev = n;
        }
        return head;
    }

    public static void print(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" <=> ");
            temp =temp.next;
        }
        System.out.println("null");
        System.out.println();
    }

    public static Node deleteHead(Node head){
        if(head ==null || head.next==null){
            return null;
        }
        Node prev= head;
        head = head.next;
        head.prev=null;
        prev.next = null;
        return head;

    }

    public static Node deleteTail(Node head){
        if(head ==null || head.next==null){
            return null;
        }
        Node tail = head;
        while (tail.next !=null){
            tail=tail.next;
        }
        Node prevTail = tail.prev;
        prevTail.next =null;
        tail.prev = null;
        return head;
    }

    public static Node deleteK(Node head, int k){
        Node temp = head;
        int cnt=0;
        while (temp.next !=null){
            cnt++;
            if(cnt == k){
                break;
            }
            temp=temp.next;
        }
        Node prevEl = temp.prev;
        Node nextEl = temp.next;
        if(prevEl ==null && nextEl ==null){
            return null;
        }
        else if(prevEl == null){
            deleteHead(head);
        }
        else if(nextEl == null){
            deleteTail(head);
        }
        prevEl.next =nextEl;
        nextEl.prev=prevEl;
        temp.next = temp.prev =null;
        return head;
    }

    public static Node insertBeforeHead(Node head, int v){
        Node newNode = new Node(v,head,null);
        head.prev = newNode;
        return newNode;
    }

    public static Node insertBeforeTail(Node head, int v){
        if(head.next==null){
            insertBeforeHead(head,v);
            return head;
        }
        Node tail =head;
        while (tail.next !=null){
            tail = tail.next;
        }
        Node prevel =tail.prev;
        Node newNode= new Node(v,tail,prevel);
        prevel.next = newNode;
        tail.prev=newNode;
        return head;
    }

    public static Node insertBeforeK(Node head, int k ,int v){
        if(k==1){
            return insertBeforeHead(head,v);
        }
        Node temp = head;
        int cnt=0;
        while (temp.next!=null){
            cnt++;
            if(cnt == k){
                break;
            }
            temp = temp.next;
        }
        Node prevel = temp.prev;
        Node newnode= new Node(v,temp,prevel);
        prevel.next =newnode;
        temp.prev = newnode;
        return head;
    }



    public static void main(String[] args) {
        int[]arr= {1,2,3,4};
       Node head= convert2L(arr);
        print(head);
        head = insertBeforeTail(head,3);
        print(head);
    }
}
