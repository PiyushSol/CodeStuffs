public class DeleteAllOccurencesinDLL {
   static class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        ListNode() {
            val = 0;
            next = null;
            prev = null;
        }

        ListNode(int data1) {
            val = data1;
            next = null;
            prev = null;
        }

        ListNode(int data1, ListNode next1, ListNode prev1) {
            val = data1;
            next = next1;
            prev = prev1;
        }
    }

    public static ListNode deleteAllOccurrences(ListNode head, int target) {
        ListNode temp = head;
        ListNode nextNode = null , prevNode =null;
        while (temp!=null){
            if(temp.val == target){
                if(temp == head){
                   head = head.next;
                }
                nextNode=temp.next;
                prevNode=temp.prev;

                if(nextNode!=null)nextNode.prev = prevNode;
                if(prevNode!=null)prevNode.next= nextNode;
                temp = nextNode;
            }
            else{
            temp = temp.next;
        }
        }
        return head;
    }
}
