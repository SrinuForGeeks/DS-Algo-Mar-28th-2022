public class LFUCache {
    
    int LFUCounter = 0;
    Map<Integer, DLList> counterMap = null;
    Map<Integer, Node> keyMap = null;
    int capacity;
    

    public LFUCache(int capacity) {
        counterMap = new HashMap<>();
        keyMap = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        
        // Case2 Accessing valid Key & Updating the LFUCounter.
        if(keyMap.containsKey(key))
        {
          Node node = keyMap.get(key);
          if(node.counter == LFUCounter && counterMap.get(LFUCounter).size == 1)
          {
              LFUCounter = LFUCounter+1;
          }
        
        DLList list =  counterMap.get(node.counter);
        list.remove(node);
            
        node.counter = node.counter+1;
            
        counterMap.putIfAbsent(node.counter, new DLList());
        counterMap.get(node.counter).add(node);
        
        return node.value;
            
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        
        
        if(capacity == 0)
        {
            return;
        }

        // Case 1: Adding new (key,value) & cache is not filled:
        if(keyMap.size() < capacity && keyMap.containsKey(key) == false)
        {


            Node node = new Node(key,value);
            keyMap.put(key, node);
            LFUCounter = 1;
            counterMap.putIfAbsent(1, new DLList());
            counterMap.get(1).add(node);  
           
        }else if( keyMap.size() == capacity && keyMap.containsKey(key) == false) 
        { // Case 3: Adding (key,value) & cache is  filled, remvoe the LFU element
            


          DLList lfuList =  counterMap.get(LFUCounter);
            
            // Remove LFU element from keyMap
            Node node = lfuList.head;
            keyMap.remove(node.key);
            
            // Remove LFU element From counterMap
            counterMap.get(LFUCounter).removeHead();
            
            node = new Node(key,value);
            keyMap.put(key, node);
            LFUCounter = 1;
            counterMap.putIfAbsent(1, new DLList());
            counterMap.get(1).add(node);  
          
        }else if(keyMap.containsKey(key))// Case 4: Updating the value
        {

             Node node = keyMap.get(key);
          if(node.counter == LFUCounter && counterMap.get(LFUCounter).size == 1)
          {
              LFUCounter = LFUCounter+1;
          }
        
        DLList list =  counterMap.get(node.counter);
        list.remove(node);
            
        node.counter = node.counter+1;
          node.value = value;  
        counterMap.putIfAbsent(node.counter, new DLList());
        counterMap.get(node.counter).add(node);
        
        }
        
        
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache();
        catch.put(1,10);
        System.out.println("get(1) ---> "+cache.get(1));
        catch.put(2,20);
        catch.put(3,30);
        System.out.println("get(3) ---> "+cache.get(3));
        catch.put(4,40);
        System.out.println("get(3) ---> "+cache.get(3));
        catch.put(4,45);
        System.out.println("get(1) ---> "+cache.get(1));
    
         System.out.println("get(2) ---> "+cache.get(2));

        System.out.println("get(3) ---> "+cache.get(3));

        System.out.println("get(4) ---> "+cache.get(4));



    }
}

class DLList
{
   Node head;
   Node tail;
   int size ;
       
    public DLList()
    {
        head = null;
        tail = null;
        size = 0;
    }
    
   
    
    public void add(Node node)
    {
        
        if(head == null)
        {
            head = tail = node;
            size++;
            return;
        }
        
        
        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
        
    }
    
    public void removeHead()
    {
       
        if(head == null)
        {
            return;
        }
        
        if(head.next == null) // If we have only one node
        {
            head = null;
            tail = null;
            size --;
            return;
        }
        
        Node next = head.next;
        next.prev = null;
        head.next = null; // Helps GC
        
        head = next;
        size--;
    }
    
    public void removeTail()
    {
       
        if(head == null)
        {
            return;
        }
       
        
        Node prev = tail.prev;
        if(prev != null)
        {
         prev.next = null; 
        }
        tail.prev = null;// Helps GC
        
        tail = prev;
        size--;
    }
    
    public void remove(Node node)
    {
        if(node.prev == null)
        {
            removeHead();
        }else if(node.next == null)
        {
            removeTail();
        }else
        {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            
            node.prev = null;
            node.next = null; // Helps GC
            size--;
        }
    }
    
    public String toString()
    {
        Node current = head;
        String message = " [ ";
        while(current != null)
        {
            message += "("+ current.key +" : "+ current.value+":"+current.counter +") --->";
            current = current.next;
        }
        
         message += "null ]";
        return message;
    }
}

class Node
{
    int key;
    int value;
    int counter;
    Node prev;
    Node next;
    
    public Node(int key, int value)
    {
        this.key = key;
        this.value = value;
        counter = 1;
         prev = null;
        next = null;
    }
}
