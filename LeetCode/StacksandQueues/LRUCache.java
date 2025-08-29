import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Node head , tail;
    Map<Integer,Node> map;
    int capacity;

    class Node{
        int key;
        int val;
        Node next , prev;
        Node(int key , int val){
            this.key = key;
            this.val=val;
            this.next = this.prev=null;
        }
    }

    public void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertAfterHead(Node node){
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev =head;
    }

    public int get(int key) {
        if(!map.containsKey(key))return -1;
        Node node = map.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val =value;
            deleteNode(node);
            insertAfterHead(node);
        }else{
            if(map.size()==capacity){
                Node node = tail.prev;
                map.remove(node.key);
                deleteNode(node);
            }
            Node node = new Node(key,value);
            map.put(key,node);
            insertAfterHead(node);
        }
    }
}
