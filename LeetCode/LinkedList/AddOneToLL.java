public class AddOneToLL {
    static class ListNode{
        int data ;
        ListNode next;

        ListNode(int data, ListNode next1){
            this.data=data;
            this.next=next1;
        }

        ListNode(int data ){
            this.data = data;
            this.next = null;
        }
    }

    public static ListNode addOne(ListNode head) {
        ListNode temp = head;
       int carry = helper(temp);
       if(carry ==1){
           ListNode newNode = new ListNode(1);
           newNode.next = head;
           return newNode;
       }
        return head;
    }

    public static int helper(ListNode temp){
        if(temp == null){
            return 1;
        }
        int carry = helper(temp.next);
        temp.data += carry;
        if(temp.data <10){
            return 0;
        }
        temp.data =0;
        return 1;
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(9);
        n.next = new ListNode(9);
        n = addOne(n);
        while(n!=null){
            System.out.print(n.data+" -> ");
            n=n.next;
        }
        System.out.println();
    }
}
