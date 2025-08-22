public class DeleteMiddle {
     static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public static ListNode deleteMiddle(ListNode head) {
         if(head==null ||head.next==null)return null;
        ListNode slow = head , fast = head;
        ListNode before=null;
        while(fast!=null && fast.next!=null){
            before = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        before.next = before.next.next;
        return head;
    }

    public static ListNode convert2L(int arr[]){
        ListNode head = new ListNode(arr[0]);
        ListNode prev= head;
        for(int i=1;i< arr.length;i++){
            ListNode n = new ListNode(arr[i]);
            prev.next =n;
            prev=n;
        }
        return head;
    }

    public static void print(ListNode head){
         ListNode temp = head;
         while (temp!=null){
             System.out.print(temp.val+" ->");
             temp=temp.next;
         }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int[] arr ={1};
        ListNode head = convert2L(arr);
        print(head);
        head = deleteMiddle(head);
        print(head);
    }

}
