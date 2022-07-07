import java.util.Stack;
public class ConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        UnionFind2 ds = new UnionFind2(n);
        
         for(int index = 0 ; index < edges.length ; index++)
        {
            int[] edge = edges[index];
            
            ds.uninon(edge[0],edge[1]);
          
        }
        
        return ds.getCount();
    }
    public static void main(String[] args) {
        ConnectedComponents s = new ConnectedComponents();
        int count = s.countComponents(5, new int[][]{{0,1},{1,2},{3,4}});
        System.out.println( " {{0,1},{1,2},{3,4}} -->ConnectedComponents = "+count);
        count = s.countComponents(5, new int[][]{{0,1},{1,2},{2,3},{3,4}});
        System.out.println( " {{0,1},{1,2},{2,3},{3,4}} -->ConnectedComponents = "+count);
   
    }
}

class UnionFind2
{
    private int[] root = null;
    int count = 0;
    
    public UnionFind2(int size)
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
    
    public boolean uninon(int vx, int vy)
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