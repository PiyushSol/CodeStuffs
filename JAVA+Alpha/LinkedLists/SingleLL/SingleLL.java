



public class SingleLL{
   public static Node head;
   public static Node tail;
   public static int size=0;

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    //Operations 
    // 1. Add to Head
    public void addToHead(int data){
        Node newNode = new Node(data);
        size++;
        if(head ==null){
           head = tail= newNode;      
           return; 
        }
        
        newNode.next = head;
        head = newNode;
    }

    //2.Add to Tail
    public void addToTail(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
           head = tail= newNode;
           return; 
        }
        tail.next = newNode;
        tail = newNode;
    }

    //3.Add to a given index
    public void addToIndex(int index , int data){
        // Case 1: When Index passed is equal to zero we need to add to head
        if(index==0){
            addToHead(data);
            return;
        }

        //Case 2: When Index passed in invalid
        if(index<0 || index>size){
            System.out.println("Invalid index passed!");
            return;
        }
        Node newNode = new Node(data);
        Node temp =head;
        int i=0;
        while(i<index-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next=newNode;
        size++;
    }

    //4.Remove node from head
    public int removeHead(){
        if(size ==0){
            System.out.println("List is empty");
            return -1;
        }else if(size ==1){
            //case when head and tail is same and list only have 1 node
            int val= head.data;
            head = tail=null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    //5. Delete tail
    public int removeTail(){
        if(size ==0){
            System.out.println("List is empty");
            return -1;
        }
        else if(size ==1){
            int val= head.data;
            head = tail = null;
            size=0;
            return val;
        }
        //previous node is at index size -2
        Node prev =head;
        for(int i=0;i<size-2;i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next =null;
        tail = prev;
        size--;
        return val;
    }

    //6. Searching for an element in the linked list
    public int search(int key){
        Node temp = head;
        int i=0;
        while(temp!=null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    //7. Reversing a linked list using iterative apporoach
    public void reverseList(){
        Node prev =null;
        Node curr = tail =head;
        Node next ;
        while(curr!=null){
            next = curr.next;
            curr.next  =prev;
            prev = curr;
            curr = next; 
        }
        head =prev;
    }

    //Helper function to pass head and use recursive search
    public int helper(Node head , int key){
       if(head == null){
        return -1;
       } 

       if(head.data == key){
        return 0;
       }
       int idx = helper(head.next , key);
       if(idx == -1){
        return -1;
       }
       return idx+1;
    }

    //Recursive function to check the for key
    public int rec_Search(int key){
        return helper(head,key); 
    }

    //Printing the List
    public void printList(){
        if(head == null){ 
            System.out.println("Linked List is Empty");
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SingleLL ll = new SingleLL();
        ll.addToHead(2);
        ll.addToHead(1); 
        ll.addToTail(4);
        ll.addToTail(5);
        ll.addToIndex(2, 3);
        ll.printList();
        // System.out.println(ll.rec_Search(4));
        ll.reverseList();
        ll.printList();


    }
}