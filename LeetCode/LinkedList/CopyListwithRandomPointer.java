public class CopyListwithRandomPointer {
   static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        Node temp =head;
        //Creating Copy Nodes
        while(temp!=null){
           Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = temp.next.next;
        }

        //Connecting Random Pointers
        temp = head;
        while(temp!=null) {
           Node copy = temp.next;
            if (temp.random != null) {
                copy.random = temp.random
                        .next;
            } else {
                copy.random = null;
            }
            temp = temp.next.next;
        }

        //Connecting Next Pointers
        Node dummy = new Node(-1);
        temp = head;
        Node res= dummy;
        while(temp!=null){
            res.next = temp.next;
            temp.next = temp.next.next;
            res = res.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}
