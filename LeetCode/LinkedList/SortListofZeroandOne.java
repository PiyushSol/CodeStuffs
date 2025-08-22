public class SortListofZeroandOne {
    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val, ListNode next1){
            this.val = val;
            this.next=next1;
        }

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next==null){
            return head;
        }
        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);
        ListNode zero = zeroHead;
        ListNode one = oneHead;
        ListNode two = twoHead;
        ListNode temp = head;
        while (temp!=null){
            if(temp.val == 0){
                zero.next = temp;
                zero = temp;
            } else if (temp.val == 1) {
                one.next = temp;
                one = temp;
            }
            else {
                two.next =temp;
                two=temp;
            }
            temp = temp.next;
        }
        zero.next = (oneHead.next!=null)?oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next =null;
        return zeroHead.next;
    }

    public static void print(ListNode head){
        ListNode node = head;
        while(node!=null){
            System.out.print(node.val+" -> ");
            node=node.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(2);
        head.next.next.next =new ListNode(0);
        head.next.next.next.next =new ListNode(1);
        print(head);
        head =sortList(head);
        print(head);
    }
}
