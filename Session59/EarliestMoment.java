import java.util.TreeMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
public class EarliestMoment {
    public int earliestAcq(int[][] logs, int n) {
        
        TreeMap<Integer,Integer[]> map = new TreeMap<>();
        
        for(int index = 0 ; index < logs.length; index++)
        {
            map.put(logs[index][0], new Integer[] {logs[index][1], logs[index][2]});
        }
        
        int noOfEdges = n;
        
        UnionFind uf = new UnionFind(n);
        int result = -1;
        for(Map.Entry<Integer, Integer[]> me : map.entrySet() )
        {
            int timeStamp = me.getKey();
            Integer[] edge    = me.getValue();
            
            uf.union(edge[0], edge[1]);
            
            int edgeCount = uf.getCount();
            
            if(edgeCount == 1)
            {
                result = timeStamp;
                break;
            }
            
        }
        
        return result;
    }
    public static void main(String[] args) {
    	int[][] logs = {{0,2,0},{1,0,1},{7,0,3},{3,2,3}};
    	EarliestMoment s = new EarliestMoment();
    	int time =  s.earliestAcq(logs,4);
    	System.out.println(" Earliest Time {{0,2,0},{1,0,1},{7,0,3},{3,2,3}} --> "+time);
    }
    
}

class UnionFind
{
    private int[] root = null;
    int count = 0;
    
    public UnionFind(int size)
    {
        root = new int[size];
        count = size;
        
        for(int index = 0 ; index < size; index++)
        {
            root[index] = index;
        }
    }
    
    public int find(int v)
    {
        Stack<Integer> stack = new Stack<>();
        while(v != root[v])
        {
            v = root[v];
            stack.push(v);
        }
        
        while( !stack.isEmpty())
        {
            root[stack.pop()] = v;
        }
        
        return v;
    }
    
    public boolean union(int vx, int vy)
    {
        int rootX = find(vx);
        int rootY = find(vy);
        
        if(rootX == rootY)
        {
            return false;
        }
        
        root[rootY] = rootX;
        count--;
        
        return true;
    }
    
    public int getCount()
    {
        return count;
    }
}