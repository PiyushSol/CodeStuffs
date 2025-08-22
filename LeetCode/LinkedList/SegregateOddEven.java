public class SegregateOddEven {
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

    public static ListNode oddEvenList(ListNode head) {
        if(head==null || head.next ==null){
            return head;
        }
        ListNode even = head.next;
        ListNode odd = head;
        ListNode evenhead = head.next;
        while(even!=null && even.next!=null){
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }
        odd.next= evenhead;
        return head;
    }

    public static void main(String[] args) {

    }
}
