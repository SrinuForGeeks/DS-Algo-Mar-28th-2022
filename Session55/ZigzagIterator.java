import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class ZigzagIterator {
    
    Queue< Queue<Integer> > queues = new LinkedList<>();

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        
        Queue<Integer> queue1 = new LinkedList<>();
        for(Integer e1 : v1)
        {
            queue1.add(e1);
        }
        
        Queue<Integer> queue2 = new LinkedList<>();
        for(Integer e2 : v2)
        {
            queue2.add(e2);
        }
        
        if(!queue1.isEmpty())
                 queues.add(queue1);
    
         if(!queue2.isEmpty())
        queues.add(queue2);


    }

    public int next() {
        
        Queue<Integer> currentQueue = queues.poll();
        int element = currentQueue.poll();
        if(!currentQueue.isEmpty())
        {
            queues.add(currentQueue);
        }
        
        return element;
        
    }

    public boolean hasNext() {
        
        return queues.size() > 0;
    }

    public static void main(String[] args) {
    	ZigzagIterator iterator = new ZigzagIterator(List.of(1,2,3,4), List.of(5,6));

    	while(iterator.hasNext())
    	{
    		System.out.println(iterator.next());
    	}
    }
}