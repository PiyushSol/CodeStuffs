public class ReverseNodesinKGroup {
    static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head , nextNode = null ,prevNode =null;
        while (temp!=null){
            ListNode kthNode = getKthNode(temp,k);
            if(kthNode ==null){
                if(prevNode!=null){
                    prevNode.next =temp;
                }
                break;
            }
            nextNode = kthNode.next;
            kthNode.next =null;
            reverseList(temp);
            if(temp == head){
                head = kthNode;
            }
            else{
                prevNode.next =kthNode;
            }
            prevNode =temp;
            temp = nextNode;
        }
        return head;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode front ;
        ListNode prev=null;
        while(temp!=null){
            front = temp.next;
            temp.next =prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static ListNode getKthNode(ListNode temp , int k){
        k = k-1;
        while(temp!=null && k>0){
            k--;
            temp= temp.next;
        }
        return  temp;
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
    int arr[]={1,2};
    ListNode head = convert2L(arr);
    print(head);
    head= reverseKGroup(head,3);
    print(head);
    }

}
