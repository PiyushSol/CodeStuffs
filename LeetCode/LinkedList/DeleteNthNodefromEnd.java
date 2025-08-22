public class DeleteNthNodefromEnd {
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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        for(int i=0;i<n;i++){
            fast = fast.next;
        }
        if(fast==null){
            return head.next;
        }
        ListNode slow = head;
        while(fast.next!=null){
            slow=slow.next;
            fast =fast.next;
        }

        slow.next = slow.next.next;
        return head;

    }

    public static void main(String[] args) {

    }
}
