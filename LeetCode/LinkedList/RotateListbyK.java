public class RotateListbyK {
      static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static ListNode rotateRightR(ListNode head, int k) {
        if(head == null || head.next==null){
            return head;
        }
        ListNode temp = head;
        while(k>0){
            k--;
            ListNode prev=temp , last = temp;
            while (temp.next!=null){
                prev = temp;
                temp = temp.next;
            }
            temp.next = last;
            prev.next =null;
        }
        return temp;
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head ==null || head.next==null||k==0)return head;
        int len =1;
        ListNode tail = head;
        while(tail.next!=null){
            len++;
            tail = tail.next;
        }
        if(k%len == 0)return head;
        k = k%len;
        tail.next = head;
        ListNode nthNode = getNthNode(head,len-k);
        head = nthNode.next;
        nthNode.next=null;
        return head;

    }

    public static ListNode getNthNode(ListNode temp, int k){
          int cnt =1;
          while(temp!=null){
            if(cnt == k)return temp;
            cnt++;
            temp=temp.next;
          }
          return temp;
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
        int[]arr ={1,2,3,4,5};
        ListNode head = convert2L(arr);
        print(head);
        head = rotateRight(head,2);
        print(head);
    }
}
