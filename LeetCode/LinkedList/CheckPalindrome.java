public class CheckPalindrome {
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

    public static boolean isPalindrome(ListNode head) {
       ListNode slow = head , fast = head;
       while(fast.next!=null && fast.next.next!=null){
           slow = slow.next;
           fast = fast.next.next;
       }
       ListNode newhead = reverseList(slow.next);
       ListNode first = head , second = newhead;
       while(second!=null){
           if(first.val !=second.val){
               reverseList(newhead);
               return false;
           }
           first = first.next;
           second = second.next;
       }
       reverseList(newhead);
       return true;
    }

    public static void print(ListNode head){
        ListNode node = head;
        while(node!=null){
            System.out.print(node.val+" -> ");
            node=node.next;
        }
        System.out.println("null");
    }

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
        ListNode head= new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(1);
        print(head);
        System.out.println(isPalindrome(head));
    }

}
