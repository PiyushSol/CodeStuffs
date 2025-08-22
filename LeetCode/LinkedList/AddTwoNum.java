public class AddTwoNum {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2= l2;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry =0 ;
        while(t1 !=null || t2 !=null){
            int sum= carry;
            if(t1!=null){
                sum+= t1.data;
            }
            if(t2!=null){
                sum+= t2.data;
            }
            ListNode node = new ListNode(sum%10);
            carry = sum/10;
            curr.next = node;
            curr = curr.next;
            if(t1!=null){
               t1 = t1.next;
            }
            if(t2!=null){
                t2 = t2.next;
            }
        }
        if(carry!=0){
            ListNode n = new ListNode(carry);
            curr.next = n;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
