import java.util.Queue;
import java.util.LinkedList;

public class HitCounter {

    Queue<Integer> queue = new LinkedList<>();
    public HitCounter() {
        
    }
    
    public void hit(int timestamp) {
        queue.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        
        while(!queue.isEmpty() && timestamp - queue.peek() >= 300)
        {
            queue.remove();
        }
        
        return queue.size();
    }
    public static void main(String[] args) {
        HitCounter s = new HitCounter();
        s.hit(1);
        
        s.hit(2);

        s.hit(3);

        System.out.println(" getHits(4) "+s.getHits(4));
        s.hit(300);
       System.out.println(" getHits(300) "+s.getHits(300));
       System.out.println(" getHits(301) "+s.getHits(301));




    }
}