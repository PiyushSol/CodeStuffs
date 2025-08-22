public class FlattenLL {
    static class ListNode {
        int val;
        ListNode next;
        ListNode child;

        ListNode() {
            val = 0;
            next = null;
            child = null;
        }

        ListNode(int data1) {
            val = data1;
            next = null;
            child = null;
        }

        ListNode(int data1, ListNode next1, ListNode next2) {
            val = data1;
            next = next1;
            child = next2;
        }
    }

    public static ListNode flattenLinkedList(ListNode head) {
    if(head == null || head.next==null){
        return head;
    }
    ListNode newHead = flattenLinkedList(head.next);
    return merge(head, newHead);
    }

    //MergeList Vertically
    public static ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                res.child = l1;
                res = l1;
                l1 = l1.child;
            }else {
                res.child = l2;
                res = l2;
                l2 = l2.child;
            }
            res.next =null;
        }
        if(l1!=null){
            res.child =l1;
        }else{
            res.child=l2;
        }
        return dummy.child;
    }
}
