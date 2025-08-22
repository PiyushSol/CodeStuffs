public class ReverseList {
    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val,ListNode next1){
            this.val = val;
            this.next=next1;
        }

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static void print(ListNode head){
        ListNode node = head;
        while(node!=null){
            System.out.print(node.val+" -> ");
            node=node.next;
        }
        System.out.println("null");
    }

    //Iterative
    public static ListNode IterativereverseList(ListNode head) {
        ListNode temp = head;
        ListNode front ;
        ListNode prev=null;
        while(temp!=null){
            front = temp.next;
            temp.next =prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    //Recursive
    public static ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode newhead = reverseList(head.next);
        ListNode front  = head.next;
        front.next = head;
        head.next =null;
        return newhead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        print(head);
        head=reverseList(head);
        print(head);
    }
}
