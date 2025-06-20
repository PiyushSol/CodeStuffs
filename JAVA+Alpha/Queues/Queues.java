
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Queues {
    static class QueueA{
        static int arr[];
        static int size;
        static int rear;

        QueueA(int n){
            arr = new int[n];
            size=n;
            rear =-1;
        }

        public static boolean isEmpty(){
            return rear ==-1;
        }

        public static void add(int data){
            if(rear==size-1){
                System.out.println("queue is full");
                return;
            }
            rear = rear+1;
            arr[rear]=data;
            return;
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            int front = arr[0];
            for(int i=0;i<rear;i++){
                arr[i]=arr[i+1];
            }
            rear=rear-1;
            return front;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            return arr[0];
        }


    }

    public static void main(String[] args) {
           
        }

    //Reverse Queue
    public static void reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }    

    //Interleave String
    public static void interleave(Queue<Integer> q){
        Queue<Integer> first = new LinkedList<>();
        int size= q.size();
        for(int i=0;i<size/2;i++){
            first.add(q.remove());
        }
        while(!first.isEmpty()){
            q.add(first.remove());
            q.add(q.remove());
        }
    }

    //First Non-repeating string
    public static void firstNonRepeat(String str){
        int freq[]= new int[26];
        Queue<Character> q = new LinkedList<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.println(-1);
            }else{
                System.out.println(q.peek());
            }
        }

    }

    }


