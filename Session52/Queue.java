class Node 
{
    int data;
    Node prev;
    Node next;

    public Node(int data)
    {
        this.data = data;
        prev = null;
        next = null;
    }

}

public class Queue
{
    private Node dummyHead = null;
    private Node dummyTail = null;

    public Queue()
    {
        dummyHead = new Node(-1);
        dummyTail = new Node(-1);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;

    }

    /*
        Time Complexity : O(1)
    */
    public boolean enQueue(int element)
    {
        Node node = new Node(element);

        Node currentRear = dummyTail.prev;

        currentRear.next = node;
        node.prev = currentRear;

        node.next = dummyTail;
        dummyTail.prev = node;

        return true;

    }

      /*
        Time Complexity : O(1)
    */
    public boolean deQueue()
    {
        if(dummyHead.next == dummyTail)
        {
            return false;
        }

        Node currentFront = dummyHead.next;

        dummyHead.next = currentFront.next;
        currentFront.next.prev = dummyHead;

        currentFront.next = null;
        currentFront.prev = null; // Helps GC 

        return true;
    }

    /*
        Time Complexity : O(n)
    */
    public boolean search(int element)
    {
        if(dummyHead.next == dummyTail)
        {
            return false;
        }

        Node current = dummyHead.next;

        while(current != dummyTail)
        {
            if(element == current.data)
            {
                return true;
            }

            current = current.next;
        }

        return false;

    }

    /*
        Time Complexity : O(1)
    */
    public int front()
    {
        if(dummyHead.next == dummyTail)
        {
            return -1;
        }
        return dummyHead.next.data;
    }

      /*
        Time Complexity : O(1)
    */
    public int rear()
    {
        if(dummyHead.next == dummyTail)
        {
            return -1;
        }
        return dummyTail.prev.data;
    }

    public void print()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[ front->");


        Node current = dummyHead.next;

        while(current != dummyTail)
        {
            sb.append(current.data+" ->");
            current = current.next;
        }


        sb.append("rear ]");

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enQueue(10);
        
        queue.enQueue(20);

        queue.enQueue(30);

        System.out.println(" \n After Add 10,20,30");

        queue.print();


        queue.deQueue();
         System.out.println(" \n After 1stDeque");
        queue.print();

        queue.deQueue();
        System.out.println(" \n After 2nd Deque");
        queue.print();
        


    }
}

