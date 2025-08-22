public class IntersectionOfTwoLL {
    static class ListNode{
        int val ;
        ListNode next;

        ListNode(int val, ListNode next1){
            this.val=val;
            this.next=next1;
        }

        ListNode(int val ){
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode t1 = headA, t2 = headB;
        while (t1 != t2) {
            t1 = t1.next;
            t2 = t2.next;

            if (t1 == t2) {
                return t1;
            }

            if (t1 == null) {
                t1 = headB;
            }
            if (t2 == null) {
                t2 = headA;
            }
        }
        return t1;
    }
}
