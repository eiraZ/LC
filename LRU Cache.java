/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get 
and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should 
invalidate the least recently used item before inserting a new item.

*/

public class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    Node first;
    Node last;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        first = null;
        last = null;
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            Node cur = map.get(key);
            int value = cur.val;
            remove(cur);
            addToHead(cur);
            return value;
        }else{
            return -1;
        }
    }
    public void set(int key, int value){
        if (map.containsKey(key)){
            Node cur = map.get(key);
            cur.val = value;
            
            remove(cur);
            addToHead(cur);
        }else{
            Node cur = new Node(key, value);
            if(map.size() == capacity){
                map.remove(last.key);
                remove(last);
                addToHead(cur);
                map.put(key, cur);
            }else{
                addToHead(cur);
                map.put(key, cur);
            }
        }
    }
    
    class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    private void remove(Node node){
        Node pre = node.pre;
        Node next = node.next;
        
        if(pre!=null){
            pre.next = next;
        }else{
            first = next;
        }
        if (next != null){
            next.pre = pre;
        }else{
            last = pre;
        }
        node.pre = null;
        node.next = null;
    }
    
    private void addToHead(Node node){
        Node temp = first;
        node.next = temp;
        if(temp!=null){
            temp.pre = node;
        }
        first = node;
        if(temp == null){
            last = node;
        }
    }
}
