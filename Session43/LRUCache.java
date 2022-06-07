import java.util.Map;
import java.util.HashMap;
public class LRUCache {
    
    Map<Integer, Node> map = null;
    DLL list = null;
    int capacity = 0;

    public LRUCache(int capacity) {
        
        map = new HashMap<>();
        list = new DLL();
        this.capacity = capacity;
        
    }
    
    /*
    Time Complexity : O(1)
    */
    public int get(int key) {

        if(map.containsKey(key))
        {
            Node node = map.get(key);
        
            if(node.next != null) // Check if the node is not tail
            {
              list.remove(node);
              list.add(node);  
            }
           
            return node.value; 
        }
        
        return -1;
    }
    
    /*
    Time Complexity : O(1)
    */
    public void put(int key, int value) {
        
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            node.value = value;
            
            if(node.next != null) // Check if the node is not tail
            {
              list.remove(node);
              list.add(node);  
            }
           
            return; 
        }
        
        if(map.size() == capacity)
        {
            map.remove(list.head.key);
            list.removeHead();
        }
        
        Node node = new Node(key,value);
        map.put(key, node);
        list.add(node);
       
    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,10);
        cache.put(2,20);
        System.out.println("Key:1 --> "+cache.get(1));

        cache.put(3,30);
        System.out.println("Key:2 --> "+cache.get(2));

        cache.put(1,15);
        cache.put(4,45);
         System.out.println("Key:3 --> "+cache.get(3));
        
         System.out.println("Key:1 --> "+cache.get(1));

         System.out.println("Key:4 --> "+cache.get(4));


    }
}

class DLL
{
    Node head;
    Node tail;
    
    public DLL()
    {
        head = null;
        tail = null;
    }
    
    public void removeHead()
    {
        if(head == null || head.next == null)
        {
            head = null;
            tail = null;
            return;
        }
        
        Node next = head.next;
        next.prev = null;
        head = next;
    }
    
    public void removeTail()
    {
        if(tail == null || tail.prev == null)
        {
            head = null;
            tail = null;
            return;
        }
       
        Node prev = tail.prev;
        prev.next = null;
        tail = prev;
    }
    
    public void add(Node node)
    {
        if(head == null)
        {
            head = tail = node;
        }else
        {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }
    
    public void remove(Node node)
    {
        Node prev = node.prev;
        Node next = node.next;
        
        if(prev == null) // head check
        {
             removeHead();
        }
        else if(next == null) // tail check
        {
            removeTail();
            
        }else{
             prev.next = next;
             next.prev = prev;
        }
        node.next = null;
        node.prev = null;
    }
    
    public void print()
    {
        Node current = head;
        while(current != null)
        {
            System.out.print("("+current.key+", "+current.value+")-->");
            current = current.next;
        }
         System.out.print( " null \n\n");
    }
}

class Node
{
    Node prev;
    Node next;
    int key;
    int value;
    
    public Node(int key, int value)
    {
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */